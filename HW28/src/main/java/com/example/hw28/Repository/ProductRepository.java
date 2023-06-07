package com.example.hw28.Repository;

import com.example.hw28.Model.Product;
import com.example.hw28.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findUsersById(Integer id);

}
