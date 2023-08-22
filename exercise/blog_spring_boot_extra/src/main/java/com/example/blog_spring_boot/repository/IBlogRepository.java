package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchName);
}
