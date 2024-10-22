package com.firstproject.ecommerce.domain.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.firstproject.ecommerce.domain.dto.base.BaseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto extends BaseDto {
    private String name;
    @JsonManagedReference
    private List<ProductDto> products;
}
