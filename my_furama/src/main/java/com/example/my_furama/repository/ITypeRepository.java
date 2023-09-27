package com.example.my_furama.repository;

import com.example.my_furama.model.TypeCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<TypeCustomer, Integer> {
}
