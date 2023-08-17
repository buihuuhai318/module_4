package com.example.product_manager_spring_boot.repository;

import com.example.product_manager_spring_boot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

}
