package com.firstproject.ecommerce.repository.abstracts;

import com.firstproject.ecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findAllWithBasketItems();
}
