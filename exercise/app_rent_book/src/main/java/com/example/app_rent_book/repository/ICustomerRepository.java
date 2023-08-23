package com.example.app_rent_book.repository;

import com.example.app_rent_book.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
