package com.example.validate_info_music.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Size(max = 800)
    @Pattern(regexp = "^[^@;,.=+…-]+$", message = "Title contains invalid characters")
    private String name;

    @NotEmpty
    @Size(max = 300)
    @Pattern(regexp = "^[^@;,.=+…-]+$", message = "Title contains invalid characters")
    private String singer;

    @NotEmpty
    @Size(max = 1000)
    @Pattern(regexp = "^[^@;.=+…-]+$", message = "Title contains invalid characters")
    private String type;

    public Music(String name, String singer, String type) {
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public Music() {
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
}
