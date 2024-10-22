package com.firstproject.ecommerce.application.abstractions;

import com.firstproject.ecommerce.domain.dto.CategoryDto;
import com.firstproject.ecommerce.domain.dto.create.CreateCategoryDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateCategoryDto;

import java.util.List;

public interface ICategoryService {
    public List<CategoryDto> getCategories();
    public CategoryDto getCategoriesById(long id);
    public void create(CreateCategoryDto dto);
    public void addProduct(long productId, long categoryId);
    public void removeProduct(long productId, long categoryId);
    public void update(UpdateCategoryDto dto);
    public void delete(long id);
}
