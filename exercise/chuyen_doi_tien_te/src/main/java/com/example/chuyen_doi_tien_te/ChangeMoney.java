package com.example.chuyen_doi_tien_te;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeMoney {

    @GetMapping("/change")
    public String show() {
        return "change";
    }

    @PostMapping("/change")
    public String changing(@RequestParam int input, Model model) {
        int output = input * 23000;
        model.addAttribute("output", output);
        model.addAttribute("input", input);
        return "change";
    }
}
