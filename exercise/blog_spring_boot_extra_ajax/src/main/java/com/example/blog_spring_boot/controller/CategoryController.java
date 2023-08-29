package com.example.blog_spring_boot.controller;

import com.example.blog_spring_boot.model.Author;
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

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/create")
    public String showCreateCategory(Model model) {
        model.addAttribute("category", new Category());
        return "createCategory";
    }

    @PostMapping("/create")
    public String saveCategory(Category category, RedirectAttributes redirectAttributes) {
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "New Category Created Successfully!");
        return "redirect:/categories";
    }

    @GetMapping("")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id, RedirectAttributes redirectAttributes) {
        categoryService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Category Deleted Successfully!");
        return "redirect:/categories";
    }
}
