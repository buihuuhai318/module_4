package com.example.channuoiheo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String code;

    private String leader;

    private String employee;

    private String note;

    private String dateStart;

    private String dateEnd;

    @ManyToOne
    @JoinColumn(name = "fix_id", referencedColumnName = "id")
    private FixMethod fixMethod;

    private int available;
}
