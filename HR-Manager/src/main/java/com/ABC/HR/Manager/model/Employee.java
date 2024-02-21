package com.ABC.HR.Manager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(max = 20)
    private Integer employeeId;

    @Column(name = "name")
    @NotNull(message = "Employee Name is required")
    @Size(min = 1, max = 64)
    private String employeeName;

    @Column(name = "birthday")
    @NotNull(message = "Birthday is required")
    @Size(min = 1, max = 64)
    private String birthday;

    @Column(name = "phoneNumber")
    @NotNull(message = "Phone Number is required")
    @Size(min = 1, max = 11)
    private String phoneNumber;

    @Column(name = "email")
    @NotNull(message = "Email is required")
    @Size(min = 1, max = 11)
    private String email;

    public Employee() {
    }

    public Employee(Integer employeeId, String employeeName, String birthday, String phoneNumber, String email) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
