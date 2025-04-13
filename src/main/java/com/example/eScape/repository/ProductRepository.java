package com.example.eScape.repository;

import com.example.eScape.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductRepository {
    @Select("SELECT * FROM product")
    List<Product> findAll();

    @Select("SELECT * FROM product WHERE subcategoryid = #{subCategoryId}")
    List<Product> findBySubCategory(String subCategoryId);

    @Select("SELECT * FROM product WHERE productid = #{id}")
    Optional<Product> findById(String id);

    @Insert("""
        INSERT INTO product (productid, productname, description, subcategoryid)
        VALUES (#{productId}, #{productName}, #{description}, #{subCategoryId})
    """)
    void insert(Product product);

    @Update("""
        UPDATE product
        SET productname = #{productName}, description = #{description}, subcategoryid = #{subCategoryId}
        WHERE productid = #{productId}
    """)
    void update(Product product);
}
