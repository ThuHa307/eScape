package com.example.eScape.dto.ProductDetailsDTO;

import com.example.eScape.validation.custome.ValidSize;
import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.ProductDetailFilterGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsRequestDTO {
    @NotBlank(message = "Product details id must not be blank", groups = UpdateGroup.class)
    private String productDetailId;
    @NotBlank(message = "Product id must not be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String productId;
    @NotBlank(message = "Size must not be blank", groups = {UpdateGroup.class, InsertGroup.class, ProductDetailFilterGroup.class})
    @ValidSize
    private String size;
    @NotBlank(message = "Color must not be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String color;
    @NotNull(message = "Price must not be null", groups = {UpdateGroup.class, InsertGroup.class, ProductDetailFilterGroup.class})
    @Min(value = 1, message = "Price must be greater than 0")
    private double price;
    @NotNull(message = "Quantity must not be null", groups = {UpdateGroup.class, InsertGroup.class})
    @Min(value = 1, message = "Price must be greater than 0")
    private int quantity;
    @NotBlank(message = "Product image must not be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String productImage;
    private String subImage;
}
