package com.example.app_rent_book.repository;

import com.example.app_rent_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findBookByNameContaining(Pageable pageable, String name);
}
