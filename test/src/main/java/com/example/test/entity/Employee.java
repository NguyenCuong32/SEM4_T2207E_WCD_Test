package com.example.Test.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employeeId")
    public String employeeId;
    @Column(name = "employeeName")
    public String employeeName;
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date birthday;
    @Column(name = "phoneNumber")
    public String phoneNumber;
    @Column(name = "email")
    public String email;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
