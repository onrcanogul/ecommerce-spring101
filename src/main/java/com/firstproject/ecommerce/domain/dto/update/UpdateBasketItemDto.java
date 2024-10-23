package com.firstproject.ecommerce.domain.dto.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBasketItemDto {
    private long id;
    private int quantity;
}
