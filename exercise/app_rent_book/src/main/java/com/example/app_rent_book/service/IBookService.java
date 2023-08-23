package com.example.app_rent_book.service;

import com.example.app_rent_book.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends IGenerateService<Book> {
    Page<Book> findBookByNameContaining(Pageable pageable, String name);

    Book borrowBook(int id);

    Book returnBook(int id);
}
