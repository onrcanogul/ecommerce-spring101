package com.firstproject.ecommerce.application.concretes;

import com.firstproject.ecommerce.application.abstractions.IBasketService;
import com.firstproject.ecommerce.core.services.MapperService;
import com.firstproject.ecommerce.domain.Basket;
import com.firstproject.ecommerce.domain.User;
import com.firstproject.ecommerce.domain.dto.BasketDto;
import com.firstproject.ecommerce.domain.dto.UserDto;
import com.firstproject.ecommerce.domain.dto.create.CreateBasketDto;
import com.firstproject.ecommerce.repository.abstracts.BasketRepository;
import com.firstproject.ecommerce.repository.abstracts.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BasketService implements IBasketService {
    private BasketRepository repository;
    private MapperService mapper;
    private UserRepository userRepository;
    public BasketService(BasketRepository repository, MapperService mapper, UserRepository userRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public BasketDto getByUser(long userId) {
        return mapper.toDto(repository.findByUser_Id(userId),BasketDto.class);
    }

    @Override
    public void create(CreateBasketDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        BasketDto basketDto = new BasketDto();
        Basket entity = mapper.toEntity(basketDto, Basket.class);

        entity.setUser(user);
        repository.save(entity);
    }
}
