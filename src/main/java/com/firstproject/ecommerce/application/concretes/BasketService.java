package com.firstproject.ecommerce.application.concretes;

import com.firstproject.ecommerce.application.abstractions.IBasketService;
import com.firstproject.ecommerce.core.services.MapperService;
import com.firstproject.ecommerce.domain.Basket;
import com.firstproject.ecommerce.domain.dto.BasketDto;
import com.firstproject.ecommerce.domain.dto.create.CreateBasketDto;
import com.firstproject.ecommerce.repository.abstracts.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketService implements IBasketService {
    private BasketRepository repository;
    private MapperService mapper;
    public BasketService(BasketRepository repository, MapperService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BasketDto getByUser(long userId) {
        return mapper.toDto(repository.findByUser_Id(userId),BasketDto.class);
    }

    @Override
    public void create(CreateBasketDto dto) {
        BasketDto basketDto = new BasketDto();
        basketDto.getUser().setId(dto.getUserId());
        Basket entity = mapper.toEntity(basketDto, Basket.class);
        repository.save(entity);
    }
}
