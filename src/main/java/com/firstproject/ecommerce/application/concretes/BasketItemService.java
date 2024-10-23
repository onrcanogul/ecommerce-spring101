package com.firstproject.ecommerce.application.concretes;

import com.firstproject.ecommerce.application.abstractions.IBasketItemService;
import com.firstproject.ecommerce.domain.BasketItem;
import com.firstproject.ecommerce.domain.dto.BasketItemDto;
import com.firstproject.ecommerce.domain.dto.create.CreateBasketItemDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateBasketItemDto;
import com.firstproject.ecommerce.repository.abstracts.BasketItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketItemService implements IBasketItemService {
    private BasketItemRepository repository;
    private ModelMapper mapper;
    public BasketItemService(BasketItemRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<BasketItemDto> getByBasket(long id) {
        return repository.findByBasket_Id(id).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void addOrUpdateQuantity(CreateBasketItemDto dto) {
        BasketItem basketItem = repository.findByProduct_IdAndBasket_Id(dto.getProductId(), dto.getBasketId());
        if(basketItem == null) {
            basketItem = mapper.map(dto, BasketItem.class);
        } else {
            basketItem.setQuantity(basketItem.getQuantity() + 1);
        }
        repository.save(basketItem);
    }

    @Override
    public void updateQuantity(UpdateBasketItemDto dto) throws ClassNotFoundException {
        BasketItem basketItem = repository.findById(dto.getId()).orElse(null);
        if(basketItem == null) throw new ClassNotFoundException();
        basketItem.setQuantity(dto.getQuantity());
        repository.save(basketItem);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    public BasketItemDto convertToDto(BasketItem basketItem) {
        return mapper.map(basketItem, BasketItemDto.class);
    }
    public BasketItem convertToEntity(BasketItemDto dto) {
        return mapper.map(dto, BasketItem.class);
    }
}
