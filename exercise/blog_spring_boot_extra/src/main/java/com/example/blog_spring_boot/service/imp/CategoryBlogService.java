package com.example.blog_spring_boot.service.imp;

import com.example.blog_spring_boot.model.CategoryBlog;
import com.example.blog_spring_boot.repository.ICategoryBlogRepository;
import com.example.blog_spring_boot.service.ICategoryBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryBlogService implements ICategoryBlogService {

    @Autowired
    private ICategoryBlogRepository categoryBlogRepository;

    @Override
    public List<CategoryBlog> findAll() {
        return categoryBlogRepository.findAll();
    }

    @Override
    public Optional<CategoryBlog> findById(Long id) {
        return categoryBlogRepository.findById(id);
    }

    @Override
    public void save(CategoryBlog categoryBlog) {
        categoryBlogRepository.save(categoryBlog);
    }

    @Override
    public void remove(Long id) {
        categoryBlogRepository.deleteById(id);
    }
}
