package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGenerateService<Blog> {
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchName);

    Page<Blog> findBlogByCategoriesContaining(Category category, Pageable pageable);
}
