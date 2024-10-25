package com.firstproject.ecommerce.application.concretes;

import com.firstproject.ecommerce.application.abstractions.IOrderService;
import com.firstproject.ecommerce.core.services.MapperService;
import com.firstproject.ecommerce.domain.Basket;
import com.firstproject.ecommerce.domain.Order;
import com.firstproject.ecommerce.domain.dto.OrderDto;
import com.firstproject.ecommerce.domain.dto.create.CreateOrderDto;
import com.firstproject.ecommerce.domain.enums.OrderStatus;
import com.firstproject.ecommerce.repository.abstracts.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository repository;
    private final MapperService mapperService;
    public OrderService(OrderRepository repository, MapperService mapperService) {
        this.repository = repository;
        this.mapperService = mapperService;
    }

    @Override
    public List<OrderDto> getBasketByUser(long userId) throws ClassNotFoundException {
        List<Order> order = repository.findByBasket_User_Id(userId);
        if(order.stream().count() == 0) throw new ClassNotFoundException();
        return mapperService.toDtoList(order, OrderDto.class);
    }

    @Override
    public void createOrder(CreateOrderDto dto) {
        Order order = new Order();
        order.setBasket(new Basket());
        order.getBasket().setId(dto.getBasketId());
        order.setStatus(OrderStatus.Pending);
        repository.save(order);
    }

    @Override
    public void completeOrder(long orderId) throws ClassNotFoundException {
        Order order = repository.findById(orderId).orElseThrow(() -> new ClassNotFoundException());
        order.setStatus(OrderStatus.Completed);
        repository.save(order);
    }

    @Override
    public void cancelOrder(long orderId) throws ClassNotFoundException {
        Order order = repository.findById(orderId).orElseThrow(() -> new ClassNotFoundException());
        order.setStatus(OrderStatus.Cancelled);
        repository.save(order);
    }
}
