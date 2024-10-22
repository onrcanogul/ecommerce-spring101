package com.firstproject.ecommerce.application.concretes;

import com.firstproject.ecommerce.application.abstractions.IProductService;
import com.firstproject.ecommerce.domain.Product;
import com.firstproject.ecommerce.domain.User;
import com.firstproject.ecommerce.domain.dto.ProductDto;
import com.firstproject.ecommerce.domain.dto.create.CreateProductDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateProductDto;
import com.firstproject.ecommerce.repository.abstracts.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private ProductRepository repository;
    private ModelMapper mapper;

    public ProductService(ProductRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductDto> getAll() {
        return repository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getByUser(long userId) {
        var products = repository.findByUser_Id(userId);
        return products.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getByCategory(long categoryId) {
        var products = repository.findByCategories_Id(categoryId);
        return products.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto getById(long id) {
        return convertToDto(repository.getById(id));
    }

    @Override
    public void create(CreateProductDto model) {
        var user = new User();
        var product = mapper.map(model, Product.class);
        user.setId(model.getUserId());
        repository.save(product);
    }

    @Override
    public void update(UpdateProductDto product) throws ChangeSetPersister.NotFoundException {
        var entity = repository.findById(product.getId()).get();
        if(entity == null) throw new ChangeSetPersister.NotFoundException();
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        repository.save(entity);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    public ProductDto convertToDto(Product product) {
        return mapper.map(product, ProductDto.class);
    }
    public Product convertToEntity(ProductDto productDTO) {
        return mapper.map(productDTO, Product.class);
    }
}
