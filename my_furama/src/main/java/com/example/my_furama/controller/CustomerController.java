package com.example.my_furama.controller;

import com.example.my_furama.model.Customer;
import com.example.my_furama.model.TypeCustomer;
import com.example.my_furama.service.ICustomerService;
import com.example.my_furama.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ITypeService typeService;

    @GetMapping
    public ResponseEntity<Page<Customer>> list(@RequestParam(name = "_limit") int limit,
                                               @RequestParam(name = "_page") int page,
                                               @RequestParam(name = "name_like") Optional<String> searchName) {
        String valueSearch = "";
        if (searchName.isPresent()) {
            valueSearch = searchName.get();
        }
        Pageable pageable = PageRequest.of(page, limit);
        Page<Customer> customerList = customerService.findBlogByNameContaining(pageable, valueSearch);
        if (customerList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        customerService.save(customer);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Customer> edit(@RequestBody Customer customer, @PathVariable int id) {
        customerService.save(customer);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable int id) {
        Customer customer = customerService.findById(id).orElse(null);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable int id) {
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
