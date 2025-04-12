package com.example.eScape.service;

import com.example.eScape.dto.CategoryDTO.CategoryRequestDTO;
import com.example.eScape.dto.CategoryDTO.CategoryResponseDTO;
import com.example.eScape.exception.DuplicateResourceException;
import com.example.eScape.model.Category;
import com.example.eScape.repository.CategoryRepository;
import com.example.eScape.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void testFindAll_ShouldReturnCategories() {
        // Given
        Category category = new Category("1L", "Technology");
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));

        // When
        List<CategoryResponseDTO> result = categoryService.findAll();

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getCategoryName()).isEqualTo("Technology");

        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testInsert_NewCategory_ShouldInsertSuccessfully() {
        // Given
        CategoryRequestDTO requestDTO = new CategoryRequestDTO();
        requestDTO.setCategoryName("Education");

        when(categoryRepository.findByName("Education")).thenReturn(null);

        // When
        categoryService.insert(requestDTO);

        // Then
        verify(categoryRepository, times(1)).insert(any(Category.class));
    }

    @Test
    void testInsert_DuplicateCategory_ShouldThrowException() {
        // Given
        CategoryRequestDTO requestDTO = new CategoryRequestDTO();
        requestDTO.setCategoryName("Technology");

        Category existingCategory = new Category("1L", "Technology");
        when(categoryRepository.findByName("Technology")).thenReturn(existingCategory);

        // When & Then
        assertThatThrownBy(() -> categoryService.insert(requestDTO))
                .isInstanceOf(DuplicateResourceException.class)
                .hasMessage("Category name already exists");

        verify(categoryRepository, never()).insert(any(Category.class));
    }
}