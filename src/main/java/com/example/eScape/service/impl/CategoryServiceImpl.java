package com.example.eScape.service.impl;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.dto.CategoryDTO.CategoryRequestDTO;
import com.example.eScape.dto.CategoryDTO.CategoryResponseDTO;
import com.example.eScape.exception.DuplicateResourceException;
import com.example.eScape.repository.CategoryRepository;
import com.example.eScape.model.Category;
import com.example.eScape.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(cat -> new CategoryResponseDTO(cat.getCategoryId(), cat.getCategoryName()))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void insert(CategoryRequestDTO categoryRequestDTO) {
        Category existing = categoryRepository.findByName(categoryRequestDTO.getCategoryName());
        if (existing != null) {
            throw new DuplicateResourceException(ApiConstants.CATEGORY_DUPLICATE);
        }

        Category category = new Category();
        category.setCategoryId(UUID.randomUUID().toString());
        category.setCategoryName(categoryRequestDTO.getCategoryName());

        categoryRepository.insert(category);
    }
}
