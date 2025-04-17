package com.example.eScape.mapper;

import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsRequestDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsResponseDTO;
import com.example.eScape.model.ProductDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDetailsMapper {
    ProductDetails toEntity(ProductDetailsRequestDTO productResponseDTO);
    ProductDetailsResponseDTO toResponseDTO(ProductDetails productDetails);
}
