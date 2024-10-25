package com.firstproject.ecommerce.api;

import com.firstproject.ecommerce.application.abstractions.IOrderService;
import com.firstproject.ecommerce.domain.dto.OrderDto;
import com.firstproject.ecommerce.domain.dto.create.CreateOrderDto;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private IOrderService service;
    public OrderController(IOrderService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDto>> get(@PathVariable long userId) throws ClassNotFoundException {
        return ResponseEntity.ok(service.getBasketByUser(userId));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateOrderDto dto){
        service.createOrder(dto);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/cancel/{orderId}")
    public ResponseEntity<Void> cancel(@PathVariable long orderId) throws ClassNotFoundException {
        service.cancelOrder(orderId);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/complete/{orderId}")
    public ResponseEntity<Void> complete(@PathVariable long orderId) throws ClassNotFoundException {
        service.completeOrder(orderId);
        return ResponseEntity.ok().build();
    }
}
