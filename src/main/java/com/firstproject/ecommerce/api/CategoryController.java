package com.firstproject.ecommerce.api;

import com.firstproject.ecommerce.application.abstractions.ICategoryService;
import com.firstproject.ecommerce.domain.dto.CategoryDto;
import com.firstproject.ecommerce.domain.dto.create.CreateCategoryDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateCategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private ICategoryService service;
    public CategoryController(ICategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> get(){
        return ResponseEntity.ok(service.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable long id){
        return ResponseEntity.ok(service.getCategoriesById(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateCategoryDto dto){
        service.create(dto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/add-product/{productId}/{categoryId}")
    public ResponseEntity<Void> addProduct(@PathVariable long productId, @PathVariable long categoryId){
        service.addProduct(productId, categoryId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/remove-product/{productId}/{categoryId}")
    public ResponseEntity<Void> removeProduct(@PathVariable long productId, @PathVariable long categoryId){
        service.removeProduct(productId, categoryId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateCategoryDto dto){
        service.update(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
