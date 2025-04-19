package com.example.eScape.repository;

import com.example.eScape.dto.ProductDetailsDTO.ProductDetailsResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductDetailsVariantsRepository {
    void dropAvailableColors();
    void createAvailableColors();
    void populateAvailableColors(@Param("productId") String productId);

    void dropAvailableSizes();
    void createAvailableSizes();
    void populateAvailableSizes(@Param("productId") String productId);

    void dropActiveSizes();
    void createActiveSizes();
    void populateActiveSizes(@Param("productId") String productId, @Param("color") String color);

    Optional<ProductDetailsResponseDTO> getFinalResult(@Param("productId") String productId, @Param("color") String color);
}
