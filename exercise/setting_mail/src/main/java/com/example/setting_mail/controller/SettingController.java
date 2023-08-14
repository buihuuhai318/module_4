package com.example.setting_mail.controller;

import com.example.setting_mail.model.Setting;
import com.example.setting_mail.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SettingController {

    @Autowired
    private ISettingService settingService;

    @GetMapping("/setting")
    public String show(Model model) {
        Setting setting = settingService.getElement();
        model.addAttribute("setting", setting);
        return "show";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Setting setting = settingService.getElement();
        model.addAttribute("setting", setting);
        return "setting";
    }

    @PostMapping("/save")
    public String save(Model model, @RequestParam String languages, @RequestParam int size, @RequestParam(defaultValue = "0",required = false) String spam, @RequestParam String signature) {
        Setting setting = settingService.getElement();
        setting.setFilter(spam.equals("1"));
        setting.setLanguages(languages);
        setting.setSignature(signature);
        setting.setPageSize(size);
        model.addAttribute("setting", setting);
        return "show";
    }
}
