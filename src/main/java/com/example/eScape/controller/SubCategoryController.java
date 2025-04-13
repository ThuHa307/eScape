package com.example.eScape.controller;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.common.ApiResponse;
import com.example.eScape.dto.SubCategoryDTO.SubCategoryRequestDTO;
import com.example.eScape.dto.SubCategoryDTO.SubCategoryResponseDTO;
import com.example.eScape.service.SubCategoryService;
import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sub-categories")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SubCategoryResponseDTO>>> getSubCategoriesByCategory(
            @RequestParam String categoryId) {
        var subCategories = subCategoryService.findByCategoryId(categoryId);
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.SUBCATEGORY_FETCHED_SUCCESS, subCategories));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> insertSubCategory(
            @Validated(InsertGroup.class) @RequestBody SubCategoryRequestDTO subCategoryRequestDTO) {
        subCategoryService.insert(subCategoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, ApiConstants.SUBCATEGORY_CREATED_SUCCESS));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Void>> updateSubCategory(
            @Validated(UpdateGroup.class) @RequestBody SubCategoryRequestDTO subCategoryRequestDTO) {
        subCategoryService.update(subCategoryRequestDTO);
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.SUBCATEGORY_UPDATED_SUCCESS));
    }
}
