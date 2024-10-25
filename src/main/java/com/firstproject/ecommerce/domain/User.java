package com.firstproject.ecommerce.domain;

import com.firstproject.ecommerce.core.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {
    private String userName;
    private String name;
    private String hashedPassword;

    public User(long id){
        this.setId(id);
    }
}
