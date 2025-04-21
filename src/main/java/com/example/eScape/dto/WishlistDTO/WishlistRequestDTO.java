package com.example.eScape.dto.WishlistDTO;

import com.example.eScape.validation.groups.InsertGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistRequestDTO {
    private String wishlistid;
    @NotBlank(message = "User id is required!", groups = {InsertGroup.class})
    private String userid;
    @NotBlank(message = "Product id is required!", groups = {InsertGroup.class})
    private String productdetailid;
}
