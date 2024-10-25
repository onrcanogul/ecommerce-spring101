package com.firstproject.ecommerce.application.abstractions;

import com.firstproject.ecommerce.domain.dto.OrderDto;
import com.firstproject.ecommerce.domain.dto.create.CreateOrderDto;

import java.util.List;

public interface IOrderService {
     List<OrderDto> getBasketByUser(long userId) throws ClassNotFoundException;
     void createOrder(CreateOrderDto dto);
     void completeOrder(long orderId) throws ClassNotFoundException;
     void cancelOrder(long orderId) throws ClassNotFoundException;
}
