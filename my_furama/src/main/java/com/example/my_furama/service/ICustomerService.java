package com.example.my_furama.service;

import com.example.my_furama.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGenerateService<Customer> {
    Page<Customer> findBlogByNameContaining(Pageable pageable, String name);
}
