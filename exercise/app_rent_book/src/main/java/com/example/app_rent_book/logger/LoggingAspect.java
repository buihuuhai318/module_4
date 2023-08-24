package com.example.app_rent_book.logger;

import com.example.app_rent_book.model.Book;
import com.example.app_rent_book.model.Log;
import com.example.app_rent_book.service.IBookService;
import com.example.app_rent_book.service.ILogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Aspect
@Component
public class LoggingAspect {

    @Autowired
    private ILogService logService;

    @Autowired
    private IBookService bookService;

    private static int count;

    @AfterReturning("execution(* com.example.app_rent_book.service.imp.BookService.borrowBook(..))")
    public void bookBorrow(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Book book = bookService.findById((int)args[0]).orElse(null);
        Log log = new Log("sách " + book.getName() + " đã được thuê", LocalDate.now());
        logService.save(log);
    }

    @AfterReturning("execution(* com.example.app_rent_book.service.imp.BookService.returnBook(..))")
    public void bookReturn(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Book book = bookService.findById((int)args[0]).orElse(null);
        Log log = new Log("sách " + book.getName() + " đã được trả", LocalDate.now());
        logService.save(log);
    }

    @After("execution(* com.example.app_rent_book.controller.RentController.*(..))")
    public void visit(JoinPoint joinPoint) {
        count++;
        Log log = new Log("số lượt truy cập hiện tại là: " + count, LocalDate.now());
        logService.save(log);
    }
}