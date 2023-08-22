package com.example.form_create_validation.repository;

import com.example.form_create_validation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
