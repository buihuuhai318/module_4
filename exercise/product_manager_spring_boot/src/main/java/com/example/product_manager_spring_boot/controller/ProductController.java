package com.example.product_manager_spring_boot.controller;

import com.example.product_manager_spring_boot.model.Product;
import com.example.product_manager_spring_boot.service.IProductService;
import com.example.product_manager_spring_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("message", "New product created successfully");
        return modelAndView;
    }

    @GetMapping("")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/product/update");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update")
    public ModelAndView updateProduct(Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/update");
        modelAndView.addObject("product", product);
        modelAndView.addObject("message", "Product updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable long id) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/product/delete");
            modelAndView.addObject("product", product.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/delete")
    public String deleteProduct(Product product) {
        productService.remove(product.getId());
        return "redirect:/products";
    }
}
