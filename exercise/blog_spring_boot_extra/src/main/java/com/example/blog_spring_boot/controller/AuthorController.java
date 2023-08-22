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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @PostMapping("/create")
    public String saveAuthor(Author author, RedirectAttributes redirectAttributes) {
        authorService.save(author);
        redirectAttributes.addFlashAttribute("message", "New Author Created Successfully!");
        return "redirect:/authors";
    }

    @GetMapping("/create")
    public String showCreateAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "createAuthor";
    }

    @GetMapping("")
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
