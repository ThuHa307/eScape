package com.example.eScape.service;

import com.example.eScape.dto.CategoryDTO.CategoryRequestDTO;
import com.example.eScape.dto.CategoryDTO.CategoryResponseDTO;
import com.example.eScape.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDTO> findAll();
    void insert(CategoryRequestDTO category);
}
