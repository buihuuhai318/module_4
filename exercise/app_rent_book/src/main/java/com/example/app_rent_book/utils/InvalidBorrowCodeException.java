package com.example.app_rent_book.utils;

public class InvalidBorrowCodeException extends RuntimeException {
    public InvalidBorrowCodeException(String message) {
        super(message);
    }
}
