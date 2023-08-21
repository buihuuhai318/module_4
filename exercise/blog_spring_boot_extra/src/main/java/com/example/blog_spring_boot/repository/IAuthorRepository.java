package com.example.blog_spring_boot.repository;

import com.example.blog_spring_boot.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author, Long> {
}
