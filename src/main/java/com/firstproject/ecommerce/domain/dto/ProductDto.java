package com.firstproject.ecommerce.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.firstproject.ecommerce.domain.dto.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends BaseDto {
    private String name;
    private String description;
    private double price;
    private List<ImageDto> images = new ArrayList<>();
    @JsonBackReference
    private List<CategoryDto> categories = new ArrayList<>();
    private UserDto user;
}
