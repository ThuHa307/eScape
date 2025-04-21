package com.example.eScape.service.impl;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsRequestDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsResponseDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductFilterRequest;
import com.example.eScape.exception.DuplicateResourceException;
import com.example.eScape.exception.ResourceNotFoundException;
import com.example.eScape.mapper.ProductDetailsMapper;
import com.example.eScape.repository.ProductDetailsRepository;
import com.example.eScape.repository.ProductDetailsVariantsRepository;
import com.example.eScape.service.ProductDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductDetailsVariantsRepository productDetailsVariantsRepository;
    private final ProductDetailsMapper productDetailsMapper;

    @Override
    public List<ProductDetailsResponseDTO> findAll() {
        return productDetailsRepository.findAll()
                .stream()
                .map(productDetailsMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDetailsResponseDTO> findByProductId(String productId) {
        return productDetailsRepository.findByProductId(productId);
    }

    @Override
    public Optional<ProductDetailsResponseDTO> findById(String productId) {
        return productDetailsRepository.findById(productId)
                .map(productDetailsMapper::toResponseDTO);
    }

    @Override
    public Optional<ProductDetailsResponseDTO> findByCriteria(String productId, String color, String size) {
        return productDetailsRepository.findByCriteria(productId, color,size);
    }

    @Override
    public List<ProductDetailsResponseDTO> findCollections(ProductFilterRequest productFilterRequest) {
        return productDetailsRepository.findCollections(productFilterRequest);
    }

    @Override
    @Transactional
    public Optional<ProductDetailsResponseDTO> getProductDetails(String productId, String color) {
        productDetailsVariantsRepository.dropAvailableColors();
        productDetailsVariantsRepository.createAvailableColors();
        productDetailsVariantsRepository.populateAvailableColors(productId);

        productDetailsVariantsRepository.dropAvailableSizes();
        productDetailsVariantsRepository.createAvailableSizes();
        productDetailsVariantsRepository.populateAvailableSizes(productId);

        productDetailsVariantsRepository.dropActiveSizes();
        productDetailsVariantsRepository.createActiveSizes();
        productDetailsVariantsRepository.populateActiveSizes(productId, color);

        return productDetailsVariantsRepository.getFinalResult(productId, color);
    }

    @Override
    public void insert(ProductDetailsRequestDTO productDTO) {
        var existingProductDetails = findByCriteria(
                productDTO.getProductId(), productDTO.getColor(), productDTO.getSize());
        if (existingProductDetails.isPresent()) {
            throw new DuplicateResourceException(ApiConstants.PRODUCTDETAIL_DUPLICATE);
        }

        var productDetail = productDetailsMapper.toEntity(productDTO);
        productDetail.setProductDetailId(UUID.randomUUID().toString());
        productDetailsRepository.insert(productDetail);
    }

    @Override
    public void update(ProductDetailsRequestDTO productDTO) {
        var existingProductDetails = productDetailsRepository.findById(productDTO.getProductId());
        if (existingProductDetails.isEmpty()) {
            throw new ResourceNotFoundException(ApiConstants.RESOURCE_NOT_FOUND);
        }
        var productDetail = productDetailsMapper.toEntity(productDTO);
        productDetailsRepository.update(productDetail);
    }
}
