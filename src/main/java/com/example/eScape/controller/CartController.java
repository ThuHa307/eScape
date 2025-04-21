package com.example.eScape.controller;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.common.ApiResponse;
import com.example.eScape.dto.CartDTO.CartRequestDTO;
import com.example.eScape.dto.CartDTO.CartResponseDTO;
import com.example.eScape.service.CartService;
import com.example.eScape.validation.groups.DeleteGroup;
import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartService cartService;

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<List<CartResponseDTO>>> getCartByUserId(@PathVariable String id) {
        var cart = cartService.findByUserId(id);
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.CART_ITEM_FETCHED_SUCCESS, cart));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createCart(
            @Validated(InsertGroup.class) @RequestBody CartRequestDTO cartRequestDTO) {
        cartService.insertCart(cartRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(true, ApiConstants.CART_ITEM_CREATED_SUCCESS)
        );
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Void>> updateCart(
            @Validated(UpdateGroup.class) @RequestBody CartRequestDTO cartRequestDTO) {
        cartService.updateCart(cartRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(true, ApiConstants.CART_ITEM_UPDATED_SUCCESS)
        );
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Void>> deleteCart(
            @Validated(DeleteGroup.class) @RequestBody CartRequestDTO cartRequestDTO) {
        cartService.deleteCart(cartRequestDTO.getCartId());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>(true, ApiConstants.CART_ITEM_DELETED_SUCCESS)
        );
    }
}
