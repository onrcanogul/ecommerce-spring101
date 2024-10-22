package com.firstproject.ecommerce.application.abstractions;

import com.firstproject.ecommerce.domain.dto.ProductDto;
import com.firstproject.ecommerce.domain.dto.create.CreateProductDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateProductDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAll();
    List<ProductDto> getByUser(long userId);
    List<ProductDto> getByCategory(long categoryId);
    ProductDto getById(long id);
    void create(CreateProductDto model);
    void update(UpdateProductDto product) throws ChangeSetPersister.NotFoundException;
    void delete(long id);
}
