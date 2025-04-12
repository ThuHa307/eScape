package com.example.eScape.repository;

import com.example.eScape.model.SubCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface SubCategoryRepository {
    @Select("SELECT * FROM SubCategory")
    List<SubCategory> findAll();

    @Select("SELECT * FROM SubCategory WHERE CategoryId = #{categoryId}")
    List<SubCategory> findByCategoryId(String categoryId);

    @Select("SELECT * FROM SubCategory WHERE subcategoryid = #{id}")
    Optional<SubCategory> findById(String id);

    @Select("SELECT * FROM SubCategory WHERE SubCategoryName = #{subCategoryName}")
    Optional<SubCategory> findBySubCategoryName(String subCategoryName);

    @Insert("INSERT INTO SubCategory(subcategoryid, subcategoryname, categoryid) VALUES (#{subCategoryId}, #{subCategoryName}, #{categoryId})")
    void insert(SubCategory subCategory);

    @Update("UPDATE SubCategory SET subcategoryname = #{subCategoryName}, categoryid = #{categoryId} WHERE subcategoryid = #{subCategoryId}")
    void update(SubCategory subCategory);
}
