package com.example.eScape.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class Category {
    private String categoryId;
    private String categoryName;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean isDeleted;

    public Category(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

}
