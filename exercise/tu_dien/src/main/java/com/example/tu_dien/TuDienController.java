package com.example.tu_dien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TuDienController {

    @GetMapping("/tuDien")
    public String show() {
        return "tu_dien";
    }

    @PostMapping("/tuDien")
    public String tuDien(@RequestParam String input, Model model) {
        Map<String, String> tuDien = new HashMap<>();
        tuDien.put("hello", "xin chao");
        tuDien.put("hi", "xin chao");
        tuDien.put("good", "tot lam");
        tuDien.put("bad", "te");
        String output = tuDien.get(input.trim().toLowerCase());
        model.addAttribute("input", input);
        model.addAttribute("output", output);
        return "tu_dien";
    }
}
