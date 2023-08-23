package com.example.app_rent_book.controller;

import com.example.app_rent_book.model.Book;
import com.example.app_rent_book.model.Customer;
import com.example.app_rent_book.model.RentDetail;
import com.example.app_rent_book.service.IBookService;
import com.example.app_rent_book.service.ICustomerService;
import com.example.app_rent_book.service.IRentDetailService;
import com.example.app_rent_book.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/rents")
public class RentController {
    @Autowired
    private IRentDetailService rentDetailService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/book/{id}")
    public String showRent(Model model, @PathVariable int id) {
        Book book = bookService.findById(id).orElse(null);
        RentDetail rentDetail = new RentDetail();
        rentDetail.setBook(book);
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("book", book);
        model.addAttribute("customers", customerList);
        model.addAttribute("rent", rentDetail);
        return "rent";
    }

    @PostMapping("/book/rent")
    public String rent(Model model, RentDetail rentDetail) {
        String code = Utils.randomCode();
        rentDetail.setCode(code);
        rentDetailService.save(rentDetail);
        Book book = rentDetail.getBook();
        book.setQuantity(book.getQuantity() - 1);
        bookService.save(book);
        model.addAttribute("rentDetail", rentDetail);
        return "info";
    }

    @GetMapping("/paid/{status}")
    public String showRentStatus(Model model, @PathVariable int status) {
        List<RentDetail> rentDetails = rentDetailService.findAllByRentStatusContaining(status);
        model.addAttribute("rentDetail", rentDetails);
        return "rent_list";
    }

    @PostMapping("/paid")
    public String paid(Model model, @RequestParam("code") String code, @RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        RentDetail rentDetail = rentDetailService.findById(id).orElse(null);
        if (rentDetail.getCode().equals(code)) {
            rentDetail.setRentStatus(1);
            Book book = rentDetail.getBook();
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            rentDetailService.save(rentDetail);
            return "redirect:/rents/paid/1";
        } else {
            redirectAttributes.addFlashAttribute("message", "Code invalid!!!");
            return "redirect:/rents/paid/0";
        }
    }
}



























