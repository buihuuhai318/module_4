package com.example.lua_chon_gia_vi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class CondimentController {

    @GetMapping("/sandwich")
    public String show() {
        return "sandwich";
    }

    @PostMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "", required = false) String[] condiment, Model model) {
        List<String> list = Arrays.asList(condiment);
        model.addAttribute("list", list);
        return "sandwich";
    }
}
