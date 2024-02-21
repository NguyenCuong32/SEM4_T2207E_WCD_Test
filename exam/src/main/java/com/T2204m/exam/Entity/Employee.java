package com.T2204m.exam.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @NotNull(message = "Id is required")
    private String id;
    @NotNull(message = "Employee name is required")
    @Size(min = 2, message = "Employee name must be at least 2 characters")

    private String name;

    @NotNull(message = "birthday is required")
    private LocalDate birthday;
    @NotNull(message = "Phone number is required")
    @Size(min = 10, max = 11, message = "Phone number must be between 10 and 11 characters")
    private String phone_number;
    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee() {
    }

    public Employee(String id, String name, LocalDate birthday, String phone_number, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone_number = phone_number;
        this.email = email;
    }
}
