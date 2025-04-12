package com.example.eScape.controller;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.common.ApiResponse;
import com.example.eScape.dto.CategoryDTO.CategoryRequestDTO;
import com.example.eScape.dto.CategoryDTO.CategoryResponseDTO;
import com.example.eScape.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryResponseDTO>>> getAllCategories() {
        List<CategoryResponseDTO> categories = categoryService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.CATEGORY_FETCHED_SUCCESS, categories));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCategory(@Valid @RequestBody CategoryRequestDTO requestDTO) {
        categoryService.insert(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, ApiConstants.CATEGORY_CREATED_SUCCESS, null));
    }
}
