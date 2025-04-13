package com.example.eScape.dto.SubCategoryDTO;

import com.example.eScape.validation.groups.InsertGroup;
import com.example.eScape.validation.groups.UpdateGroup;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryRequestDTO {
    @NotBlank(message = "SubCategory id must not be blank", groups = UpdateGroup.class)
    private String subCategoryId;
    @NotBlank(message = "SubCategory name must not be blank", groups = {InsertGroup.class, UpdateGroup.class})
    private String subCategoryName;
    @NotBlank(message = "SubCategory id must not be blank", groups = {InsertGroup.class, UpdateGroup.class})
    private String categoryId;
}
