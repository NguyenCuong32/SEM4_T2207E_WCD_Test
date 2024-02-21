package com.example.demo11.entity;



import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public long id;




    @Column(name = "employeeId ")
    public String employeeId ;


    @Column(name = "employeeName")
    public String employeeName;



    @Column(name = "birthday")
    public Date birthday;
    @Column(name = "phoneNumber")
    public String phoneNumber;
    @Column(name = "email")
    public String email;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String employeeName() {
        return employeeName;
    }

    public void setemployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getbirthday() {
        return birthday;
    }
    public void setbirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String phoneNumber() {
        return phoneNumber;
    }

    public void setphoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String employeeId() {
        return employeeId;
    }

    public void setemployeeId(String employeeId) {
        this.employeeId = employeeId;
    }



    public Employee( ) {
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.employeeId= employeeId;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
