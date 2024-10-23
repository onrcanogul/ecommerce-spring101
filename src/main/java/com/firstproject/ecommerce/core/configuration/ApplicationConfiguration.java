package com.firstproject.ecommerce.core.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration<T,TDto> {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
