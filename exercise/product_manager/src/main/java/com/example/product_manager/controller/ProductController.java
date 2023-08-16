package com.example.product_manager.controller;

import com.example.product_manager.model.Product;
import com.example.product_manager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = new ArrayList<>(productService.listProduct().values());
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 10000));
        productService.createNew(product);
        redirectAttributes.addFlashAttribute("success", "created new product successfully");
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.updateProduct(product.getId(), product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(product.getId());
        redirectAttributes.addFlashAttribute("success", "removed product successfully");
        return "redirect:/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "view";
    }

    @PostMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> productList = new ArrayList<>(productService.listProduct().values());
        List<Product> productListTemp = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                productListTemp.add(product);
            }
        }
        model.addAttribute("productListTemp", productListTemp);
        return "search";
    }
}
