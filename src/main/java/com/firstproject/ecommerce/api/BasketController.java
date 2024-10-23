package com.firstproject.ecommerce.api;

import com.firstproject.ecommerce.application.concretes.BasketService;
import com.firstproject.ecommerce.domain.dto.BasketDto;
import com.firstproject.ecommerce.domain.dto.create.CreateBasketDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService service;
    public BasketController(BasketService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BasketDto> get(@PathVariable long userId) {
        return ResponseEntity.ok(service.getByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateBasketDto dto) {
        service.create(dto);
        return ResponseEntity.ok().build();
    }
}

