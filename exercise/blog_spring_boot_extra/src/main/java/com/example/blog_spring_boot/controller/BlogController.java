package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.service.IAuthorService;
import com.example.blog_spring_boot.service.IBlogService;
import com.example.blog_spring_boot.service.ICategoryBlogService;
import com.example.blog_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryBlogService categoryBlogService;
    @Autowired
    private IAuthorService authorService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create")
    public String showCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes) {
        blog.setCreateDate(LocalDate.now());
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New Blog Created Successfully!");
        return "redirect:/list";
    }

    @GetMapping("")
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }
}
