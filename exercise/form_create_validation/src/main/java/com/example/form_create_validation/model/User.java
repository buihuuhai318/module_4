package com.example.form_create_validation.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotEmpty
    @Size(min = 5, max = 45, message = "First name size must be between 5 and 45")
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 45, message = "Last name size must be between 5 and 45")
    private String lastName;

    @Pattern(regexp = "^0\\d{9}$", message = "Invalid phone number")
    private String phone;

    @Min(18)
    private int age;

    @Email
    private String email;

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 45) String firstName,
                @NotEmpty @Size(min = 5, max = 45) String lastName,
                @Pattern(regexp = "^0\\d{9}$") String phone,
                @Min(18) int age,
                @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
