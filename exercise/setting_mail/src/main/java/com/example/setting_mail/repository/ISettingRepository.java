package com.example.setting_mail.repository;

import com.example.setting_mail.model.Setting;

public interface ISettingRepository {

    Setting getElement();

    void edit(Setting settingTemp);
}
