package com.firstproject.ecommerce.application.concretes;

import com.firstproject.ecommerce.application.abstractions.ICategoryService;
import com.firstproject.ecommerce.domain.Category;
import com.firstproject.ecommerce.domain.dto.CategoryDto;
import com.firstproject.ecommerce.domain.dto.create.CreateCategoryDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateCategoryDto;
import com.firstproject.ecommerce.repository.abstracts.CategoryRepository;
import com.firstproject.ecommerce.repository.abstracts.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    private ModelMapper mapper;
    private CategoryRepository repository;
    private ProductRepository productRepository;

    public CategoryService(CategoryRepository repository, ModelMapper mapper, ProductRepository productRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    @Override
    public List<CategoryDto> getCategories() {
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getCategoriesById(long id) {
        return repository.findById(id).map(this::convertToDto).orElse(null);
    }

    @Override
    public void create(CreateCategoryDto dto) {
        var category = mapper.map(dto, Category.class);
        repository.save(category);
    }

    @Override
    public void addProduct(long productId, long categoryId) {
        var category = repository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        var product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        category.getProducts().add(productRepository.findById(productId).orElse(null));
        product.getCategories().add(category);
        repository.save(category);
        productRepository.save(product);
    }

    @Override
    public void removeProduct(long productId, long categoryId) {
        var category = repository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        var product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        category.getProducts().remove(product);
        product.getCategories().remove(category);
        repository.save(category);
        productRepository.save(product);
    }

    @Override
    public void update(UpdateCategoryDto dto) {
        var category = repository.findById(dto.getId()).orElse(null);
        category.setName(dto.getName());
        repository.save(category);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    public CategoryDto convertToDto(Category category) {
        return mapper.map(category, CategoryDto.class);
    }
    public Category convertToEntity(CategoryDto categoryDto) {
        return mapper.map(categoryDto, Category.class);
    }
}
