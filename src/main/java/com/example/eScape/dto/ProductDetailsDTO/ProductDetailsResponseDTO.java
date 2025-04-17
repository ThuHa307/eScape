package com.example.eScape.dto.ProductDetailsDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailsResponseDTO {
    private String productDetailId;
    private String productId;
    private String productName;
    private String description;
    private String size;
    private String color;
    private String price;
    private Integer quantity;
    private String productImage;
    private String subImage;
    private String availableColors;
}
