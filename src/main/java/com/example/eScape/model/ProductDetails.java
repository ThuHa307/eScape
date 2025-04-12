package com.example.eScape.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProductDetails {
    private String productDetailId;
    private String productId;
    private String size;
    private String color;
    private double price;
    private int quantity;
    private String productImage;
    private String subImage;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private boolean isDeleted;
}
