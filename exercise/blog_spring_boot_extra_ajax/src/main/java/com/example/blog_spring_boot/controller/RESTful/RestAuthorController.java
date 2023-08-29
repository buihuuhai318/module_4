package com.example.blog_spring_boot.controller.RESTful;

import com.example.blog_spring_boot.model.Author;
import com.example.blog_spring_boot.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/authors")
public class RestAuthorController {

    @Autowired
    private IAuthorService authorService;

    @PostMapping("")
    public ResponseEntity<Author> createSmartphone(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Author>> listAuthors() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }
}
