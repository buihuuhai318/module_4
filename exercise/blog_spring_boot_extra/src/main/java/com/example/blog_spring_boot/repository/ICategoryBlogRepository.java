package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.CategoryBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryBlogRepository extends JpaRepository<CategoryBlog, Long> {
}
