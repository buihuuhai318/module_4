package com.example.form_create_validation.controller;

import com.example.form_create_validation.model.User;
import com.example.form_create_validation.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("list")
    public String showList(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("list", userList);
        return "result";
    }

    @PostMapping("/validateUser")
    public String checkValidation(@Validated User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "index";
        } else {
            userService.save(user);
            redirectAttributes.addFlashAttribute("message", "User create successfully!");
            return "redirect:/users/list";
        }
    }
}
