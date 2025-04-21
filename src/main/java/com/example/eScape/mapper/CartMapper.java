package com.example.eScape.mapper;

import com.example.eScape.dto.CartDTO.CartRequestDTO;
import com.example.eScape.dto.CartDTO.CartResponseDTO;
import com.example.eScape.model.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart toEntity(CartRequestDTO cartRequestDTO);
    CartResponseDTO toResponseDto(Cart cart);
}
