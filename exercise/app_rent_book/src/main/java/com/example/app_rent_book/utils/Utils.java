package com.example.app_rent_book.utils;

public class Utils {
    public static String randomCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            code.append((int) (Math.random() * 9));
        }
        return String.valueOf(code);
    }
}
