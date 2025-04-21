package com.example.eScape.controller;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.common.ApiResponse;
import com.example.eScape.dto.WishlistDTO.WishlistRequestDTO;
import com.example.eScape.dto.WishlistDTO.WishlistResponseDTO;
import com.example.eScape.service.WishlistService;
import com.example.eScape.validation.groups.InsertGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wishlist")
public class WishlistController {
    private final WishlistService wishlistService;

    @GetMapping("{userId}")
    public ResponseEntity<ApiResponse<List<WishlistResponseDTO>>> getWishlist(
            @NotBlank(message = "user id is required") @PathVariable String userId) {
        var wishlist = wishlistService.findAllByUser(userId);
        return ResponseEntity.ok(
            new ApiResponse<>(true, ApiConstants.WISHLIST_FETCHED_SUCCESS, wishlist)
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> createWishlist(
         @Validated(InsertGroup.class) @RequestBody WishlistRequestDTO wishlistRequestDTO) {
        wishlistService.createWishlist(wishlistRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ApiResponse<>(true, ApiConstants.WISHLIST_CREATED_SUCCESS)
        );
    }

    @DeleteMapping("{wishlistId}")
    public ResponseEntity<ApiResponse<Void>> deleteWishlist(
            @NotBlank(message = "wishlist id is required") @PathVariable String wishlistId) {
        wishlistService.deleteWishlist(wishlistId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
