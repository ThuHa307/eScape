package com.example.eScape.dto.ProductDTO;

import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    @NotBlank(message = "Product id must not be blank", groups = UpdateGroup.class)
    private String productId;
    @NotBlank(message = "Product name must not be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String productName;
    private String description;
    @NotBlank(message = "Subcategory id must not be blank", groups = {UpdateGroup.class, InsertGroup.class})
    private String subCategoryId;
}
