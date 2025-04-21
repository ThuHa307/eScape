package com.example.eScape.service;

import com.example.eScape.dto.CartDTO.CartRequestDTO;
import com.example.eScape.dto.CartDTO.CartResponseDTO;

import java.util.List;

public interface CartService {
    List<CartResponseDTO> findByUserId(String userId);
    void updateCart(CartRequestDTO cartRequestDTO);
    void insertCart(CartRequestDTO cartRequestDTO);
    void deleteCart(String cartId);
}
