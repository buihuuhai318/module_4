package com.example.my_furama.repository;

import com.example.my_furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where name like :name", nativeQuery = true)
    Page<Customer> findBlogByNameContaining(Pageable pageable, @Param("name") String name);
}
