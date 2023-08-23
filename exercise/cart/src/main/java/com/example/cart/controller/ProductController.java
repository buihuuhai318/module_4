package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart(HttpServletRequest request) {
        List<Product> productList = (List<Product>) productService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("productList", productList);
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Product> productList = (List<Product>) session.getAttribute("productList");
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productList);
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action,
                            HttpServletRequest request) {
        HttpSession session = request.getSession();
        Optional<Product> productOptional = productService.findById(id);
        List<Product> productList = (List<Product>) session.getAttribute("productList");
        for (Product product : productList) {
            if (productOptional.get().getId() == product.getId()) {
                productOptional = Optional.of(product);
            }
        }
        if (!productOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            for (Product product : productList) {
                if (productOptional.get().getId() == product.getId()) {
                    product.setQuantity(product.getQuantity() - 1);
                }
            }
            session.setAttribute("productList", productList);
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        } else if (action.equals("minus")) {
            for (Product product : productList) {
                if (productOptional.get().getId() == product.getId()) {
                    product.setQuantity(product.getQuantity() + 1);
                }
            }
            session.setAttribute("productList", productList);
            cart.minusProduct(productOptional.get());
            return "redirect:/shopping-cart";
        } else if (action.equals("remove")) {
            for (Product product : productList) {
                if (productOptional.get().getId() == product.getId()) {
                    product.setQuantity(product.getQuantity() + cart.getProducts().get(productOptional.get()));
                }
            }
            cart.getProducts().remove(productOptional.get());
            return "redirect:/shopping-cart";
        }
        for (Product product : productList) {
            if (productOptional.get().getId() == product.getId()) {
                product.setQuantity(product.getQuantity() - 1);
            }
        }
        session.setAttribute("productList", productList);
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }
}
