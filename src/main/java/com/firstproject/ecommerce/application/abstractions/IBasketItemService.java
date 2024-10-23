package com.firstproject.ecommerce.application.abstractions;

import com.firstproject.ecommerce.domain.dto.BasketItemDto;
import com.firstproject.ecommerce.domain.dto.create.CreateBasketItemDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateBasketItemDto;

import java.util.List;

public interface IBasketItemService {
    List<BasketItemDto> getByBasket(long id);
    void addOrUpdateQuantity(CreateBasketItemDto dto);
    void updateQuantity(UpdateBasketItemDto dto) throws ClassNotFoundException;
    void delete(long id);
}
