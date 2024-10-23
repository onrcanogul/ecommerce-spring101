package com.firstproject.ecommerce.domain.dto.create;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBasketItemDto {
    private long productId;
    private long basketId;
}
