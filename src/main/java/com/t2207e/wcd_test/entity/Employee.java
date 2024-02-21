package com.t2207e.wcd_test.entity;

import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @NotNull(message = "id cannot be null")
    @Column(name = "employeeid")
    public String employeeid;
    @NotNull(message = "employeeName cannot be null")
    @Column(name = "employeename")
    public String employeename;
    @NotNull(message = "birthday cannot be null")
    @Column(name = "birthday")
    public Date birthday;
    @NotNull(message = "phoneNumber cannot be null")
    @Column(name = "phonenumber")
    public String phonenumber;
    @NotNull(message = "email cannot be null")
    @Column(name = "email")
    public String email;

    public Employee(String employeeid, String employeename, Date birthday, String phonenumber, String email) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.birthday = birthday;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public Employee() {

    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeid='" + employeeid + '\'' +
                ", employeename='" + employeename + '\'' +
                ", birthday=" + birthday +
                ", phonenumber='" + phonenumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
