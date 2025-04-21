package com.example.eScape.service;

import com.example.eScape.dto.WishlistDTO.WishlistRequestDTO;
import com.example.eScape.dto.WishlistDTO.WishlistResponseDTO;

import java.util.List;

public interface WishlistService {
    List<WishlistResponseDTO> findAllByUser(String userId);
    void createWishlist(WishlistRequestDTO wishlist);
    void deleteWishlist(String wishlistId);
}
