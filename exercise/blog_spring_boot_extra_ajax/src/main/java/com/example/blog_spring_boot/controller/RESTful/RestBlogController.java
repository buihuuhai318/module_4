package com.example.blog_spring_boot.controller.RESTful;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.service.IAuthorService;
import com.example.blog_spring_boot.service.IBlogService;
import com.example.blog_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class RestBlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private IAuthorService authorService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getAll(@PageableDefault(page = 0, size = 2, sort = "create_date", direction = Sort.Direction.DESC) Pageable pageable,
                                             @RequestParam Optional<String> searchTitle) {
        String valueSearchTitle = "";
        if (searchTitle.isPresent()) {
            valueSearchTitle = searchTitle.get();
        }
        Page<Blog> blogs = blogService.findBlogByTitleContaining(pageable, valueSearchTitle);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Blog>> getAllByCategory(@PathVariable long id, @PageableDefault(page = 0, size = 2) Pageable pageable) {
        Page<Blog> blogs = blogService.findBlogByCategoriesContaining(id, pageable);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<>(blog.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
