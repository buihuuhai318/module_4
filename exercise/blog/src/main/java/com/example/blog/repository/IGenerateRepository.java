package com.example.blog.repository;

import java.util.List;

public interface IGenerateRepository<T> {
    List<T> findAll();

    T findById(long id);

    void save(T t);

    void remove(long id);
}
