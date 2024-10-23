package com.firstproject.ecommerce.domain.dto;

import com.firstproject.ecommerce.core.base.BaseDto;

public class BasketItemDto extends BaseDto {
    private int quantity;
    private BasketDto basket;
    private ProductDto product;
}
