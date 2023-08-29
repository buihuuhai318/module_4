package com.example.case_study_module_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bookings")
public class BookingController {
    @GetMapping("")
    public String viewProduct(Model model) {
        return "shop/store";
    }
}
