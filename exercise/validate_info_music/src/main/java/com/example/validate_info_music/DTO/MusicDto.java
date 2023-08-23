package com.example.validate_info_music.DTO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MusicDto implements Validator {

    private int id;

    private String name;

    private String singer;

    private String type;

    public MusicDto(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public MusicDto(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public MusicDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MusicDto musicDto = (MusicDto) target;
        if (musicDto.name.equals("")) {
            errors.rejectValue("name", null, "Name must not empty");
        } else if (!musicDto.name.matches("^[^@;,.=+…-]+$")) {
            errors.rejectValue("name", null, "Name contains invalid characters");
        } else if (musicDto.name.length() > 800) {
            errors.rejectValue("name", null, "Size must be less 800 characters");
        }

        if (musicDto.singer.equals("")) {
            errors.rejectValue("singer", null, "Singer must not empty");
        } else if (!musicDto.singer.matches("^[^@;,.=+…-]+$")) {
            errors.rejectValue("singer", null, "Singer contains invalid characters");
        } else if (musicDto.singer.length() > 300) {
            errors.rejectValue("singer", null, "Size must be less 300 characters");
        }

        if (musicDto.type.equals("")) {
            errors.rejectValue("type", null, "Type must not empty");
        } else if (!musicDto.singer.matches("^[^@;.=+…-]+$")) {
            errors.rejectValue("type", null, "Type contains invalid characters");
        } else if (musicDto.singer.length() > 1000) {
            errors.rejectValue("type", null, "Size must be less 1000 characters");
        }
    }
}
