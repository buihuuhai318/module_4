package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchTitle);

    Page<Blog> findBlogByCategoriesContaining(Category category, Pageable pageable);
}
