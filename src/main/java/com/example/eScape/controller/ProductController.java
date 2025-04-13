package com.example.eScape.controller;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.common.ApiResponse;
import com.example.eScape.dto.ProductDTO.ProductRequestDTO;
import com.example.eScape.dto.ProductDTO.ProductResponseDTO;
import com.example.eScape.service.ProductService;
import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getProducts() {
        var products = productService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.PRODUCT_FETCHED_SUCCESS, products));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<List<ProductResponseDTO>>> getProductsBySubCategory(@PathVariable("id") String id) {
        var products = productService.findAll();
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.PRODUCT_FETCHED_SUCCESS, products));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> insert(@Validated(InsertGroup.class) @RequestBody ProductRequestDTO productRequestDTO) {
        productService.insert(productRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, ApiConstants.PRODUCT_CREATED_SUCCESS));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Void>> update(@Validated(UpdateGroup.class) @RequestBody ProductRequestDTO productRequestDTO) {
        productService.update(productRequestDTO);
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.PRODUCT_UPDATED_SUCCESS));
    }
}
