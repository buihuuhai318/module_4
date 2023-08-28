package com.example.case_study_module_4.controller;

import com.example.case_study_module_4.model.product.Vehicle;
import com.example.case_study_module_4.service.IVehicleService;
import com.example.case_study_module_4.service.IVehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("products")
public class ProductController {

    @Autowired
    private IVehicleTypeService vehicleTypeService;

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping("/view/{id}")
    public String viewProduct(Model model, @PathVariable int id) {
        Vehicle vehicle = vehicleService.findById(id).orElse(null);
        model.addAttribute("car", vehicle);
        model.addAttribute("title", "View Detail");
        return "shop/single";
    }
}
