package com.firstproject.ecommerce.domain;

import com.firstproject.ecommerce.core.base.BaseEntity;
import com.firstproject.ecommerce.domain.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Order.findAllWithBasketItems",
                query = "SELECT o FROM Order o JOIN FETCH o.basket b JOIN FETCH b.basketItems bi JOIN FETCH bi.product")
})
public class Order extends BaseEntity {
    private OrderStatus status;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private Basket basket;
}
