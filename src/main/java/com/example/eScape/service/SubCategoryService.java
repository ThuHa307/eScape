package com.example.eScape.service;

import com.example.eScape.dto.SubCategoryDTO.SubCategoryRequestDTO;
import com.example.eScape.dto.SubCategoryDTO.SubCategoryResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface SubCategoryService {
    List<SubCategoryResponseDTO> findByCategoryId(String categoryId);
    void insert(SubCategoryRequestDTO category);
    void update(SubCategoryRequestDTO category);
}
