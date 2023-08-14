package com.example.setting_mail.model;

public class Setting {
    private String languages;
    private int pageSize;
    private boolean filter;
    private String signature;

    public Setting(String languages, int pageSize, boolean filter, String signature) {
        this.languages = languages;
        this.pageSize = pageSize;
        this.filter = filter;
        this.signature = signature;
    }

    public Setting() {
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
