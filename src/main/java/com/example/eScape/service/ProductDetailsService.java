package com.example.eScape.service;

import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsRequestDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsResponseDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductFilterRequest;

import java.util.List;
import java.util.Optional;

public interface ProductDetailsService {
    List<ProductDetailsResponseDTO> findAll();
    List<ProductDetailsResponseDTO> findByProductId(String productId);
    Optional<ProductDetailsResponseDTO> findById(String productId);
    List<ProductDetailsResponseDTO> findCollections(ProductFilterRequest productFilterRequest);
    Optional<ProductDetailsResponseDTO> getProductDetails(String productId, String color);
    void insert(ProductDetailsRequestDTO productResponseDTO);
    void update(ProductDetailsRequestDTO productRequestDTO);
}
