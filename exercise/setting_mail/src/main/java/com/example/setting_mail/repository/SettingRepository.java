package com.example.setting_mail.repository;

import com.example.setting_mail.model.Setting;
import org.springframework.stereotype.Repository;

@Repository
public class SettingRepository implements ISettingRepository{
    private static Setting setting = new Setting();
    @Override
    public Setting getElement() {
        return setting;
    }

    @Override
    public void edit(Setting settingTemp) {
        setting = settingTemp;
    }
}
