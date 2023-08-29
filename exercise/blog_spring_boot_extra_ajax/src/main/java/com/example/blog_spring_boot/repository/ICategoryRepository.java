package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
