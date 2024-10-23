package com.firstproject.ecommerce.domain.dto;

import com.firstproject.ecommerce.core.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketDto extends BaseDto {
    private UserDto user;
    private List<BasketItemDto> basketItems;
}
