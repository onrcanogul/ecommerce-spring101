package com.firstproject.ecommerce.repository.abstracts;

import com.firstproject.ecommerce.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
    Basket findByUser_Id(long userId);
}
