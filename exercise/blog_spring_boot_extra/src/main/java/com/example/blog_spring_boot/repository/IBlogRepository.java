package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
}
