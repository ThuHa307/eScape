package com.example.eScape.service.impl;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.dto.ProductDTO.ProductRequestDTO;
import com.example.eScape.dto.ProductDTO.ProductResponseDTO;
import com.example.eScape.exception.ResourceNotFoundException;
import com.example.eScape.mapper.ProductMapper;
import com.example.eScape.model.Product;
import com.example.eScape.repository.ProductRepository;
import com.example.eScape.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponseDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponseDTO> findBySubCategory(String subCategoryId) {
        return productRepository.findBySubCategory(subCategoryId)
                .stream()
                .map(productMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductResponseDTO> findById(String id) {
        return productRepository.findById(id)
                .map(productMapper::toResponseDto);
    }

    @Override
    public void insert(ProductRequestDTO productDto) {
        Product product = productMapper.toEntity(productDto);
        product.setProductId(UUID.randomUUID().toString());
        var name = productDto.getProductName();
        productRepository.insert(product);
    }

    @Override
    public void update(ProductRequestDTO productDto) {
        var existingProduct = productRepository.findById(productDto.getProductId());
        if (existingProduct.isEmpty()) {
            throw new ResourceNotFoundException(ApiConstants.RESOURCE_NOT_FOUND);
        }
        Product product = productMapper.toEntity(productDto);

        productRepository.update(product);
    }
}
