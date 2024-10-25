package com.firstproject.ecommerce.repository.abstracts;

import com.firstproject.ecommerce.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBasket_User_Id(long userId);
}
