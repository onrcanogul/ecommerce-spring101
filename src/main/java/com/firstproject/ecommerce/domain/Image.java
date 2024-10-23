package com.firstproject.ecommerce.domain;
import jakarta.persistence.*;
import lombok.*;
import com.firstproject.ecommerce.core.base.BaseEntity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image extends BaseEntity{

    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public Image(String url) {
        this.url = url;
    }
}