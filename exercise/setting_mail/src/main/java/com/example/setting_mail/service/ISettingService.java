package com.example.setting_mail.service;

import com.example.setting_mail.model.Setting;

public interface ISettingService {
    Setting getElement();

    void edit(Setting settingTemp);
}
