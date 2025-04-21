package com.example.eScape.mapper;

import com.example.eScape.dto.WishlistDTO.WishlistRequestDTO;
import com.example.eScape.dto.WishlistDTO.WishlistResponseDTO;
import com.example.eScape.model.Wishlist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WishlistMapper {
    Wishlist toEntity(WishlistRequestDTO wishlistRequestDTO);
    WishlistResponseDTO toResponseDto(Wishlist wishlist);
}
