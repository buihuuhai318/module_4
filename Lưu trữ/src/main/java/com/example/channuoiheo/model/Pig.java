package com.example.channuoiheo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String dateIn;

    private String dateOut;

    private int weightIn;

    private int weightOut;

    private int paymentStatus;

    private int deleteStatus;

    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id")
    private Origin origin;
}
