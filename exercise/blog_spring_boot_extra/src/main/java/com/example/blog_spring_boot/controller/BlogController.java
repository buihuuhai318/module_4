package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.model.Blog;
import com.example.blog_spring_boot.model.Category;
import com.example.blog_spring_boot.service.IAuthorService;
import com.example.blog_spring_boot.service.IBlogService;
import com.example.blog_spring_boot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

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
    public String saveBlog(Blog blog, @RequestParam("categories") List<Long> categories, RedirectAttributes redirectAttributes) {
        blog.setCreateDate(LocalDate.now());
        List<Category> categoryList = categoryService.findAllById(categories);
        blog.setCategories(categoryList);
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New Blog Created Successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("")
    public String listBlogs(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "list";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(Model model, @PathVariable long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            model.addAttribute("blog", blogService.findById(id));
            return "view";
        } else {
            return "404";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteBlog(@PathVariable long id, RedirectAttributes redirectAttributes) {
        blogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Blog Deleted Successfully!");
        return "redirect:/blogs";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(Model model, @PathVariable long id) {
        Optional<Blog> blog = blogService.findById(id);
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        if (blog.isPresent()) {
            model.addAttribute("blog", blog.get());
            return "update";
        } else {
            return "404";
        }
    }

    @PostMapping("/update")
    public String updateBlog(Blog blog, RedirectAttributes redirectAttributes, @RequestParam("categories") List<Long> selectedCategories) {
        blog.setCategories(categoryService.findAllById(selectedCategories));
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Blog Updated Successfully!");
        return "redirect:/blogs";
    }
}
