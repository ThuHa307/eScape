package com.example.eScape.mapper;

import com.example.eScape.dto.ProductDTO.ProductRequestDTO;
import com.example.eScape.dto.ProductDTO.ProductResponseDTO;
import com.example.eScape.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequestDTO productRequestDTO);
    ProductResponseDTO toResponseDto(Product product);
}
