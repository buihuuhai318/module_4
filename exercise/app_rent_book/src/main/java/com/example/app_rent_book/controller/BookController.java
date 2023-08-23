package com.example.app_rent_book.controller;

import com.example.app_rent_book.model.Book;
import com.example.app_rent_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showBooks(Model model, @PageableDefault(page = 0, size = 5)Pageable pageable, @RequestParam Optional<String> searchName) {
        String valueSearch = "";
        if (searchName.isPresent()) {
            valueSearch = searchName.get();
        }
        Page<Book> books = bookService.findBookByNameContaining(pageable, valueSearch);
        model.addAttribute("books", books);
        return "list";
    }
}
