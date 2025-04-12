package com.example.eScape.dto.SubCategoryDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryResponseDTO {
    private String subCategoryId;
    private String subCategoryName;
    private String categoryId;
}
