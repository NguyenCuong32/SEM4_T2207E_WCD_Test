package com.example.demoWDF.demo.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "employee")
public class employee {
    @Id
    @Column(name = "employeeId",columnDefinition = "varchar(20)")
    private String employeeId;
    @Column(name = "employeeName",columnDefinition = "nvarchar(256)",nullable = false)
    private String employeeName;

    @Column(name = "birthday",columnDefinition = "Date",nullable = false)
    private Date birthday;

    @Column(name = "phoneNumber",columnDefinition = "nvarchar(11)",nullable = false)
    private String phoneNumber;

    @Column(name = "email",columnDefinition = "nvarchar(256)" ,nullable = false)
    private String email;



    public employee() {}

    public employee(String employeeId, String employeeName, Date birthday, String phoneNumber, String email) {
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
