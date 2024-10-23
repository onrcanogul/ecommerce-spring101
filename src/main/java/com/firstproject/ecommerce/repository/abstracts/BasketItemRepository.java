package com.firstproject.ecommerce.repository.abstracts;

import com.firstproject.ecommerce.domain.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {
    List<BasketItem> findByBasket_Id(long id);
    BasketItem findByProduct_IdAndBasket_Id(long productId, long basketId);
}
