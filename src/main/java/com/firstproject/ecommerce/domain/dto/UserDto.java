package com.firstproject.ecommerce.domain.dto;

import com.firstproject.ecommerce.core.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto extends BaseDto {
    public UserDto(long id) {
        this.setId(id);
    }
}
