package com.example.eScape.controller;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.common.ApiResponse;
import com.example.eScape.common.PageResult;
import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsRequestDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsResponseDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductFilterRequest;
import com.example.eScape.service.ProductDetailsService;
import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-details")
public class ProductDetailsController {
    private final ProductDetailsService productDetailsService;

    @Autowired
    public ProductDetailsController(ProductDetailsService productDetailsService) {
        this.productDetailsService = productDetailsService;
    }

    @PostMapping("/collections")
    public ResponseEntity<ApiResponse<PageResult<ProductDetailsResponseDTO>>> getCollections(
            @RequestBody @Valid ProductFilterRequest productFilterRequest) {
        List<ProductDetailsResponseDTO> items = productDetailsService.findCollections(productFilterRequest);
        PageResult<ProductDetailsResponseDTO> response = new PageResult<>();
        response.setData(items);
        response.setPageNumber(productFilterRequest.getPage());
        response.setPageSize(productFilterRequest.getLimit());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(true, ApiConstants.PRODUCTDETAIL_FETCHED_SUCCESS, response));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductDetailsResponseDTO>>> getAllProductsByProductId(@RequestParam String productId) {
        var productDetails = productDetailsService.findByProductId(productId);
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.PRODUCTDETAIL_FETCHED_SUCCESS, productDetails));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> insert(@Validated(InsertGroup.class) @RequestBody ProductDetailsRequestDTO productDetailsRequestDTO) {
        productDetailsService.insert(productDetailsRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, ApiConstants.PRODUCTDETAIL_CREATED_SUCCESS));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<Void>> update(@Validated(UpdateGroup.class) @RequestBody ProductDetailsRequestDTO productDetailsRequestDTO) {
        productDetailsService.update(productDetailsRequestDTO);
        return ResponseEntity.ok(new ApiResponse<>(true, ApiConstants.PRODUCTDETAIL_UPDATED_SUCCESS));
    }
}
