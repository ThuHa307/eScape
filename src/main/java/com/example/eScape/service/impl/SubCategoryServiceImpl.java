package com.example.eScape.service.impl;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.dto.SubCategoryDTO.SubCategoryRequestDTO;
import com.example.eScape.dto.SubCategoryDTO.SubCategoryResponseDTO;
import com.example.eScape.exception.DuplicateResourceException;
import com.example.eScape.exception.ResourceNotFoundException;
import com.example.eScape.mapper.SubCategoryMapper;
import com.example.eScape.model.SubCategory;
import com.example.eScape.repository.SubCategoryRepository;
import com.example.eScape.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryMapper subCategoryMapper;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, SubCategoryMapper subCategoryMapper) {
        this.subCategoryRepository = subCategoryRepository;
        this.subCategoryMapper = subCategoryMapper;
    }

    @Override
    public List<SubCategoryResponseDTO> findByCategoryId(String categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId)
                .stream()
                .map(subCat -> new SubCategoryResponseDTO(subCat.getSubCategoryId() ,subCat.getSubCategoryName(), subCat.getCategoryId()))
                .collect(Collectors.toList());
    }

    @Override
    public void insert(SubCategoryRequestDTO category) {
        var existingSubCategory = subCategoryRepository.findBySubCategoryName(category.getSubCategoryName());
        if (existingSubCategory.isPresent()) {
            throw new DuplicateResourceException(ApiConstants.SUBCATEGORY_DUPLICATE);
        }

        SubCategory subCategory = new SubCategory();
        subCategory.setCategoryId(category.getCategoryId());
        subCategory.setSubCategoryName(category.getSubCategoryName());
        subCategory.setSubCategoryId(UUID.randomUUID().toString());

        subCategoryRepository.insert(subCategory);
    }

    @Override
    public void update(SubCategoryRequestDTO subCategoryDto) {
        var existingSubCategory = subCategoryRepository.findById(subCategoryDto.getSubCategoryId());
        if (existingSubCategory.isEmpty()) {
            throw new ResourceNotFoundException(ApiConstants.RESOURCE_NOT_FOUND);
        }

        var duplicatedName = subCategoryRepository.findBySubCategoryName(subCategoryDto.getSubCategoryName());
        if (duplicatedName.isPresent()) {
            throw new DuplicateResourceException(ApiConstants.SUBCATEGORY_DUPLICATE);
        }

        SubCategory subCategory = subCategoryMapper.toEntity(subCategoryDto);
        subCategoryRepository.update(subCategory);
    }
}
