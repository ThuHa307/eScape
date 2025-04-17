package com.example.eScape.repository;

import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsResponseDTO;
import com.example.eScape.dto.ProductDetailsDTO.ProductFilterRequest;
import com.example.eScape.model.ProductDetails;
import jakarta.validation.constraints.NotBlank;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Mapper
public interface ProductDetailsRepository {
    @Select("SELECT * FROM productdetails")
    List<ProductDetails> findAll();

    @Select("""
        SELECT PD.productdetailid, PD.productid, PD.color, PD.size, PD.price, PD.quantity, PD.productimage, PD.subimage
               , P.productname, P.description
        FROM productdetails PD
        JOIN product P ON PD.productid = P.productid
        WHERE P.productid = #{productId}
    """)
    List<ProductDetailsResponseDTO> findByProductId(String productId);

    @Select("SELECT * FROM productdetails WHERE productdetailid = #{id} ")
    Optional<ProductDetails> findById(String id);

    Optional

    List<ProductDetailsResponseDTO> findCollections(ProductFilterRequest productFilterRequest);

    @Insert("""
        INSERT INTO productdetails(productdetailid, productid, size, color, price, quantity, productimage, subimage)
        VALUES (#{productDetailId}, #{productId}, #{size}, #{color}, #{price}, #{quantity}, #{productImage}, #{subImage})
    """)
    void insert(ProductDetails productDetails);

    @Update("""
        UPDATE productdetails
        SET productid = #{productId}, size = #{size}, color = #{color}, price = #{price}, quantity = #{quantity}
            ,productimage = #{productImage}, subimage = #{subImage}
    """)
    void update(ProductDetails productDetails);

    @Select("SELECT * FROM productdetails WHERE productdetailid = #{productId} AND color = #{color} AND size = #{size} ")
    Optional<ProductDetails> findByCriteria(String productId, String color, String size);
}
