package com.example.eScape.dto.ProductDetailsDTO;

import com.example.eScape.common.Constants;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterRequest {
    @NotBlank(message = "Sub category id cannot be blank")
    private String subCategoryId;
    private List<String> colors;
    private List<String> sizes;
    private Double minPrice;
    private Double maxPrice;
    private String orderByField = Constants.PRODUCT_FILTER_ORDER_BY_FIELD;
    private String orderByDirection = Constants.PRODUCT_FILTER_ORDER_BY_DIRECTION;
    private int page = Constants.PRODUCT_FILTER_PAGE;
    private int limit = Constants.PRODUCT_FILTER_LIMIT;

    public int getOffset() {
        return (page - 1) * limit;
    }
}
