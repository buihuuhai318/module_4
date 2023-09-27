package com.example.my_furama.controller;

import com.example.my_furama.model.TypeCustomer;
import com.example.my_furama.service.ICustomerService;
import com.example.my_furama.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class TypeCustomerController {

    @Autowired
    private ITypeService typeService;

    @GetMapping("/types")
    public ResponseEntity<List<TypeCustomer>> list() {
        List<TypeCustomer> typeCustomers = typeService.findAll();
        return new ResponseEntity<>(typeCustomers, HttpStatus.OK);
    }
}
