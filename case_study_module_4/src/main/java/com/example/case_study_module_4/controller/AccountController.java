package com.example.case_study_module_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("accounts")
public class AccountController {

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("title", "Login");
        return "shop/login";
    }
}
