package org.example.exam.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "employeeId", nullable = false)
    @NotEmpty(message = "The Employee Id Field is not empty.")
    public String employeeId;

    @Column(name = "employeeName", nullable = false)
    @NotEmpty(message = "The Employee Name Field is not empty.")
    public String employeeName;

    @Column(name = "birthday", nullable = false)
    @NotEmpty(message = "The Birthday Field is not empty.")
    public Date birthday;

    @Column(name = "phoneNumber", nullable = false)
    @NotEmpty(message = "The Phone Number Field is not empty.")
    public String phoneNumber;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "The Email Field is not empty.")
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
