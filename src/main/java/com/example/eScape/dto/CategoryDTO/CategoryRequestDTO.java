package com.example.eScape.dto.CategoryDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryRequestDTO {
    @NotBlank(message = "Category name must not be blank")
    private String categoryName;
}
