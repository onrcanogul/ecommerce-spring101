package com.firstproject.ecommerce.domain.dto;

import com.firstproject.ecommerce.core.base.BaseDto;
import com.firstproject.ecommerce.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto extends BaseDto {
    private OrderStatus status;
    private BasketDto basket;
}
