package com.example.app_rent_book.service.imp;

import com.example.app_rent_book.model.Book;
import com.example.app_rent_book.repository.IBookRepository;
import com.example.app_rent_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Integer id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findBookByNameContaining(Pageable pageable, String name) {
        return bookRepository.findBookByNameContaining(pageable, name);
    }

    @Override
    public Book borrowBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null && book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
            return book;
        }
        return null;
    }

    @Override
    public Book returnBook(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
            return book;
        }
        return null;
    }
}
