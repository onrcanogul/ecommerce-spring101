package com.firstproject.ecommerce.application.abstractions;

import com.firstproject.ecommerce.domain.dto.BasketDto;
import com.firstproject.ecommerce.domain.dto.create.CreateBasketDto;


public interface IBasketService {
    BasketDto getByUser(long userId);
    void create(CreateBasketDto dto);

}
