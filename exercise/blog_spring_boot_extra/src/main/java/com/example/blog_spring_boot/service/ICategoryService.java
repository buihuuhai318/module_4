package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.model.Category;

import java.util.List;

public interface ICategoryService extends IGenerateService<Category> {
    List<Category> findAllById(List<Long> selectedCategories);
}
