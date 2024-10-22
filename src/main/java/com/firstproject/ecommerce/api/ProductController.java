package com.firstproject.ecommerce.api;

import com.firstproject.ecommerce.application.abstractions.IProductService;
import com.firstproject.ecommerce.domain.dto.ProductDto;
import com.firstproject.ecommerce.domain.dto.create.CreateProductDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateProductDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private IProductService service;
    public ProductController(IProductService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<List<ProductDto>> getByUserId(@PathVariable long userId){
        return ResponseEntity.ok(service.getByUser(userId));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateProductDto dto){
        service.create(dto);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateProductDto dto) throws ChangeSetPersister.NotFoundException {
        service.update(dto);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
