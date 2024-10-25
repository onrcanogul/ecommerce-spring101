package com.firstproject.ecommerce.domain;

import com.firstproject.ecommerce.core.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="basket_items")
@NoArgsConstructor
@AllArgsConstructor
public class BasketItem extends BaseEntity {
    private int quantity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="basket_id")
    private Basket basket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;
}
