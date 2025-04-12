package com.example.eScape.mapper;

import com.example.eScape.dto.SubCategoryDTO.SubCategoryRequestDTO;
import com.example.eScape.dto.SubCategoryDTO.SubCategoryResponseDTO;
import com.example.eScape.model.SubCategory;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {
    SubCategory toEntity(SubCategoryRequestDTO dto);
    SubCategoryResponseDTO toResponseDTO(SubCategory entity);
}