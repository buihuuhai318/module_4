package com.example.setting_mail.service;

import com.example.setting_mail.model.Setting;
import com.example.setting_mail.repository.ISettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {

    @Autowired
    private ISettingRepository settingRepository;

    @Override
    public Setting getElement() {
        return settingRepository.getElement();
    }

    @Override
    public void edit(Setting settingTemp) {
        settingRepository.edit(settingTemp);
    }
}
