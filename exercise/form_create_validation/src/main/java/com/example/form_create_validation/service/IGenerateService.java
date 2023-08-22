package com.example.form_create_validation.service;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<T> {
    List<T> findAll();

    Optional<T> findById(Integer id);

    void save(T t);

    void remove(Integer id);
}
