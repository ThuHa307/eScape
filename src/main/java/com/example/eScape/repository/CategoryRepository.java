package com.example.eScape.repository;

import com.example.eScape.model.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @Select("SELECT * FROM Category")
    List<Category> findAll();

    @Select("SELECT * FROM Category WHERE categoryname = #{categoryName}")
    Category findByName(String categoryName);

    @Insert("INSERT INTO Category(categoryid, categoryname) VALUES(#{categoryId}, #{categoryName})")
    void insert(Category category);
}
