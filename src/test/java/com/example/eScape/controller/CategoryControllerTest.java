package com.example.eScape.controller;

import com.example.eScape.common.ApiConstants;
import com.example.eScape.dto.CategoryDTO.CategoryRequestDTO;
import com.example.eScape.dto.CategoryDTO.CategoryResponseDTO;
import com.example.eScape.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CategoryService categoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testFindAll() throws Exception {
        CategoryResponseDTO category = new CategoryResponseDTO("CAT001", "Technology");
        List<CategoryResponseDTO> categories = List.of(category);

        when(categoryService.findAll()).thenReturn(categories);

        mockMvc.perform(get("/api/v1/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].categoryId").value("CAT001"))
                .andExpect(jsonPath("$.data[0].categoryName").value("Technology"));
    }

    @Test
    void testCreateCategory_Success() throws Exception {
        CategoryRequestDTO requestDTO = new CategoryRequestDTO();
        requestDTO.setCategoryName("Technology");

        // Không cần mock insert vì nó trả void

        mockMvc.perform(post("/api/v1/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value(ApiConstants.CATEGORY_CREATED_SUCCESS));
    }

    @Test
    void testCreateCategory_MissingName_ShouldReturnBadRequest() throws Exception {
        CategoryRequestDTO requestDTO = new CategoryRequestDTO();
        requestDTO.setCategoryName(""); // Tên rỗng -> lỗi validation

        mockMvc.perform(post("/api/v1/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDTO)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").exists());
    }

}
