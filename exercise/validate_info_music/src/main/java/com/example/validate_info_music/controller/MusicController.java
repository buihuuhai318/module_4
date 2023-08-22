package com.example.validate_info_music.controller;

import com.example.validate_info_music.model.Music;
import com.example.validate_info_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/musics")
public class MusicController {

    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String showList(Model model) {
        List<Music> list = musicService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated Music music, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        } else {
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "New music created successfully");
            return "redirect:/musics";
        }
    }

    @GetMapping("/update/{id}")
    public String showEdit(Model model, @PathVariable int id) {
        Music music = musicService.findById(id).orElse(null);
        model.addAttribute("music", music);
        return "update";
    }

    @PostMapping("/update")
    public String update(@Validated Music music, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "update";
        } else {
            musicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Music updated successfully");
            return "redirect:/musics";
        }
    }
}
