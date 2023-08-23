package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ShoppingController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart, HttpServletRequest request){
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public String showProduct(@PathVariable("id") int id, HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        List<Product> productList = (List<Product>) session.getAttribute("productList");
        Product productOptional = productService.findById(id).orElse(null);
        for (Product product : productList) {
            if (productOptional.getId() == product.getId()) {
                productOptional = product;
                break;
            }
        }
        model.addAttribute("product", productOptional);
        return "view";
    }

    @PostMapping("/checkout")
    public String checkOut(HttpServletRequest request, @SessionAttribute("cart") Cart cart, Model model) {
        HttpSession session = request.getSession();
        List<Product> productList = (List<Product>) session.getAttribute("productList");
        for (Product product : productList) {
            productService.save(product);
        }
        model.addAttribute("cart", cart);
        session.invalidate();
        return "checkout";
    }
}