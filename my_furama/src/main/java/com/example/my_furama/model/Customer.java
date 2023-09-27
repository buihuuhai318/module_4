package com.example.my_furama.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String birthday;

    private String gender;

    private String idCard;

    private String phone;

    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeCustomer typeCustomer;
}
