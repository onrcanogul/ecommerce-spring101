package com.firstproject.ecommerce.repository.abstracts;
import com.firstproject.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUser_Id(long id);
    List<Product> findByCategories_Id(long id);
}
