package com.example.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/calculator")
    public String show() {
        return "calculator";
    }

    @PostMapping("/save")
    public String save(@RequestParam int input1, @RequestParam int input2, String cal , Model model) {
        int result = 0;
       switch (cal) {
           case "+":
               result = input1 + input2;
               break;
           case "-":
               result = input1 - input2;
               break;
           case "*":
               result = input1 * input2;
               break;
           case "/":
               result = input1 / input2;
               break;
       }
        model.addAttribute("input1", input1);
        model.addAttribute("input2", input2);
        model.addAttribute("result", result);
        return "calculator";
    }
}
