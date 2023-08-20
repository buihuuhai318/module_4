package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/create")
    public String showCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String saveBlog(Blog blog, RedirectAttributes redirectAttributes) {
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
