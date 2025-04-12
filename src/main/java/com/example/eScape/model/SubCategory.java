package com.example.eScape.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SubCategory {
    private String subCategoryId;
    private String subCategoryName;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean isDeleted;
    private String categoryId;
}
