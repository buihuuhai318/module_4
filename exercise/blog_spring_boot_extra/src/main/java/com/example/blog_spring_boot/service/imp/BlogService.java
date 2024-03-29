package com.example.blog_spring_boot.service.imp;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.model.Category;
import com.example.blog_spring_boot.repository.IBlogRepository;
import com.example.blog_spring_boot.repository.ICategoryRepository;
import com.example.blog_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findBlogByTitleContaining(Pageable pageable, String searchTitle) {
        return blogRepository.findBlogByTitleContaining(pageable, "%" + searchTitle + "%");
    }

    @Override
    public Page<Blog> findBlogByCategoriesContaining(long categoryId, Pageable pageable) {
        return blogRepository.findBlogByCategoriesContaining(categoryId, pageable);
    }
}
