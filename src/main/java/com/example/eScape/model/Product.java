package com.example.eScape.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Product {
    private String productId;
    private String productName;
    private String description;
    private String subCategoryId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean isDeleted;
}
