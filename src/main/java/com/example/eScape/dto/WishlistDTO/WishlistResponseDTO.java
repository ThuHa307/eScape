package com.example.eScape.dto.WishlistDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WishlistResponseDTO {
    private String wishlistid;
    private String productDetailId;
    private String productId;
    private String productName;
    private String price;
    private Integer quantity;
    private String productImage;
    private String subImage;
}
