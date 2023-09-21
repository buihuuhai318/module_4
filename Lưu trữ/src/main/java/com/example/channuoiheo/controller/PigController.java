package com.example.channuoiheo.controller;

import com.example.channuoiheo.dto.PigDto;
import com.example.channuoiheo.model.Origin;
import com.example.channuoiheo.model.Pig;
import com.example.channuoiheo.service.IOriginService;
import com.example.channuoiheo.service.IPigService;
import com.example.channuoiheo.service.imp.PigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class PigController {

    @Autowired
    IPigService pigService;

    @Autowired
    IOriginService originService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pigDto", new PigDto());
        return "/create";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(Model model, @PathVariable("id") int id) {
        Pig pig = pigService.findById(id).orElse(null);
        PigDto pigDto = new PigDto();
        BeanUtils.copyProperties(pig, pigDto);
        model.addAttribute("pigDto", pigDto);
        return "/edit";
    }

    @PostMapping("/pig/edit")
    public String edit(@Validated PigDto pigDto, BindingResult bindingResult, Model model) {
        new PigDto().validate(pigDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("pigDto", pigDto);
            return "/edit";
        } else {
            Pig pig = new Pig();
            BeanUtils.copyProperties(pigDto, pig);
            pigService.save(pig);
            return "redirect:/list";
        }
    }

    @GetMapping("/sell/{id}")
    public String sell(@PathVariable("id") int id, Model model) {
        Pig pig = pigService.findById(id).orElse(null);
        pig.setDateOut(String.valueOf(LocalDate.now()));
        model.addAttribute("pig", pig);
        return "/sell";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        Pig pig = pigService.findById(id).orElse(null);
        pig.setDeleteStatus(1);
        pigService.save(pig);
        return "redirect:/list";
    }

    @PostMapping("/sell")
    public String sell(Pig pig) {
        pig.setPaymentStatus(1);
        pigService.save(pig);
        return "redirect:/list";
    }

    @ModelAttribute("origins")
    public List<Origin> showOrigins() {
        return originService.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable, @RequestParam Optional<String> search) {
        String valueSearch = "";
        if (search.isPresent()) {
            valueSearch = search.get();
        }

        Page<Pig> pigList = pigService.findAllBySearch(pageable, valueSearch);

        model.addAttribute("list", pigList);
        model.addAttribute("search", valueSearch);
        return "/list";
    }

    @PostMapping("/pig/create")
    public String createNew(@Validated PigDto pigDto, BindingResult bindingResult, Model model) {
        new PigDto().validate(pigDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("pigDto", pigDto);
            return "/create";
        } else {
            Pig pig = new Pig();
            BeanUtils.copyProperties(pigDto, pig);
            pigService.save(pig);
            return "redirect:/list";
        }
    }
}
