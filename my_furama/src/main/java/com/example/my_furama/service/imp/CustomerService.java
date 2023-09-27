package com.example.my_furama.service.imp;

import com.example.my_furama.model.Customer;
import com.example.my_furama.repository.ICustomerRepository;
import com.example.my_furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findBlogByNameContaining(Pageable pageable, String name) {
        return customerRepository.findBlogByNameContaining(pageable, "%" + name + "%");
    }
}
