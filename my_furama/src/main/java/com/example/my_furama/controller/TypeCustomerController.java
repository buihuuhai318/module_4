package com.example.my_furama.controller;

import com.example.my_furama.model.Customer;
import com.example.my_furama.model.TypeCustomer;
import com.example.my_furama.service.ICustomerService;
import com.example.my_furama.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    private ICustomerService customerService;

    @Autowired
    private ITypeService typeService;

    @GetMapping("/types")
    public ResponseEntity<List<TypeCustomer>> list() {
        List<TypeCustomer> typeCustomers = typeService.findAll();
        return new ResponseEntity<>(typeCustomers, HttpStatus.OK);
    }

//    @GetMapping("/list")
//    public String showList(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable, @RequestParam Optional<Integer> search) {
//        int valueSearch = 0;
//        if (search.isPresent()) {
//            valueSearch = search.get();
//        }
//
//        Page<Customer> pctList = customerService.findAllBySearch(pageable);
//
//        model.addAttribute("list", pctList);
//        model.addAttribute("search", valueSearch);
//        return "/list";
//    }

//    @GetMapping("/create")
//    public String showCreate(Model model) {
//        List<TypeCustomer> types = typeService.findAll();
//        return "create";
//    }

//    @PostMapping("/create")
//    public String create(Model model, @Validated PctDto pctDto, BindingResult bindingResult) {
//        List<Customer> methodList = fixMethodService.findAll();
//        model.addAttribute("methodList", methodList);
//        new PctDto().validate(pctDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("methodList", methodList);
//            model.addAttribute("pctDto", pctDto);
//            return "create";
//        } else {
//            Pct pct = new Pct();
//            BeanUtils.copyProperties(pctDto, pct);
//            pctService.save(pct);
//            return "redirect:/list";
//        }
//    }

//    @GetMapping("/delete/{id}")
//    public String delete(Model model, @PathVariable("id") int id) {
//       pctService.remove(id);
//        return "redirect:/list";
//    }
}
