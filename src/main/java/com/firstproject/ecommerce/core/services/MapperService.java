package com.firstproject.ecommerce.core.services;

import com.firstproject.ecommerce.core.base.BaseEntity;
import com.firstproject.ecommerce.core.base.BaseDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperService {

    private final ModelMapper modelMapper;

    public MapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <E extends BaseEntity, D extends BaseDto> D toDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D extends BaseDto, E extends BaseEntity> E toEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }

    public <E extends BaseEntity, D extends BaseDto> List<D> toDtoList(List<E> entities, Class<D> dtoClass) {
        return entities.stream()
                .map(entity -> toDto(entity, dtoClass))
                .collect(Collectors.toList());
    }

    public <D extends BaseDto, E extends BaseEntity> List<E> toEntityList(List<D> dtos, Class<E> entityClass) {
        return dtos.stream()
                .map(dto -> toEntity(dto, entityClass))
                .collect(Collectors.toList());
    }
}