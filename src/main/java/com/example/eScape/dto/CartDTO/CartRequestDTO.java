package com.example.eScape.dto.CartDTO;

import com.example.eScape.validation.groups.DeleteGroup;
import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartRequestDTO {
    @NotBlank(message = "Cart id cannot be blank", groups = {DeleteGroup.class, UpdateGroup.class})
    private String cartId;
    private String productDetailId;
    private Integer quantity;
    @NotBlank(message = "User id cannot be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String userId;
    @NotBlank(message = "Product id cannot be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String productId;
    @NotBlank(message = "Size cannot be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String size;
    @NotBlank(message = "Color id cannot be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String color;
}
