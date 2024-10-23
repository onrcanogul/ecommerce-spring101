package com.firstproject.ecommerce.api;

import com.firstproject.ecommerce.application.abstractions.IBasketItemService;
import com.firstproject.ecommerce.domain.dto.BasketItemDto;
import com.firstproject.ecommerce.domain.dto.create.CreateBasketItemDto;
import com.firstproject.ecommerce.domain.dto.update.UpdateBasketItemDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/basketItem")
public class BasketItemController {

    private final IBasketItemService service;
    public BasketItemController(IBasketItemService service) {
        this.service = service;
    }

    @GetMapping("/{basketId}")
    public ResponseEntity<List<BasketItemDto>> get(@PathVariable long basketId) {
        return ResponseEntity.ok(service.getByBasket(basketId));
    }

    @PostMapping
    public ResponseEntity<Void> createOrUpdate(@RequestBody CreateBasketItemDto dto) {
        service.addOrUpdateQuantity(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateBasketItemDto dto) throws ClassNotFoundException {
        service.updateQuantity(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable long basketId) {
        service.delete(basketId);
        return ResponseEntity.ok().build();
    }


}
