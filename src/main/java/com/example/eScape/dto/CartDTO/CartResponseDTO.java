package com.example.eScape.dto.CartDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartResponseDTO {
    private String cartId;
    private String productId;
    private String productDetailId;
    private int quantity;
    private String userId;
    private String productName;
    private String size;
    private String color;
    private String price;
    private String productImage;
}
