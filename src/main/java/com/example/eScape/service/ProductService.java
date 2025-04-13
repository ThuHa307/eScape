package com.example.eScape.service;

import com.example.eScape.dto.ProductDTO.ProductRequestDTO;
import com.example.eScape.dto.ProductDTO.ProductResponseDTO;
import com.example.eScape.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductResponseDTO> findAll();
    List<ProductResponseDTO> findBySubCategory(String subCategoryId);
    Optional<ProductResponseDTO> findById(String id);
    void insert(ProductRequestDTO product);
    void update(ProductRequestDTO product);
}
