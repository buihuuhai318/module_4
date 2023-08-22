package com.example.blog_spring_boot.service;

import com.example.blog_spring_boot.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGenerateService<Blog> {
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchName);
}
