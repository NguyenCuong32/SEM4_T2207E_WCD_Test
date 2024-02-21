package com.example.ExamTranThiMaiHien.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Size(max=20)
    @Column(name="employeeId")
    public String employeeId;

    @NotNull
    @Column(name="employeeName")
    @Size(max=64)
    public String employeeName;

    @Column(name="birthday")
    @NotNull
    public Date birthday;

    @NotNull
    @Size(max=11)
    @Column(name="phoneNumber")
    public String phoneNumber;

    @NotNull
    @Column(name="email")
    public String email;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, Date birthday, String phoneNumber, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
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
