package com.exam.hr_manage.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId", nullable = false, length = 20)
    private String employeeId;

    @Column(name = "employeeName", nullable = false, length = 64)
    private String employeeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthday",nullable = false)
    private Date birthday;

    @Column(name = "phoneNumber",nullable = false)
    private String phoneNumber;

    @Column(name = "email",nullable = false)
    private String email;
}
