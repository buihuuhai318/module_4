package com.example.channuoiheo.controller;

import com.example.channuoiheo.dto.PctDto;
import com.example.channuoiheo.model.FixMethod;
import com.example.channuoiheo.model.Pct;
import com.example.channuoiheo.service.IFixMethodService;
import com.example.channuoiheo.service.IPctService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PctController {

    @Autowired
    private IFixMethodService fixMethodService;

    @Autowired
    private IPctService pctService;

    @GetMapping("/list")
    public String showList(Model model, @PageableDefault(page = 0, size = 3) Pageable pageable, @RequestParam Optional<Integer> search) {
        int valueSearch = 0;
        if (search.isPresent()) {
            valueSearch = search.get();
        }

        Page<Pct> pctList = pctService.findAllBySearch(pageable);

        model.addAttribute("list", pctList);
        model.addAttribute("search", valueSearch);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<FixMethod> methodList = fixMethodService.findAll();
        model.addAttribute("methodList", methodList);
        model.addAttribute("pctDto", new PctDto());
        return "create";
    }

    @PostMapping("/create")
    public String create(Model model, @Validated PctDto pctDto, BindingResult bindingResult) {
        List<FixMethod> methodList = fixMethodService.findAll();
        model.addAttribute("methodList", methodList);
        new PctDto().validate(pctDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("methodList", methodList);
            model.addAttribute("pctDto", pctDto);
            return "create";
        } else {
            Pct pct = new Pct();
            BeanUtils.copyProperties(pctDto, pct);
            pctService.save(pct);
            return "redirect:/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable("id") int id) {
       pctService.remove(id);
        return "redirect:/list";
    }
}
