package com.example.practialwcd.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "employee_id", length = 20)
    private String employeeId;

    @Column(name = "employee_name", nullable = false, length = 64)
    @NotBlank(message = "Name is mandatory")
    @Size(max = 64, message = "Name must be lest than 64 characters")
    private String employeeName;

    @Column(name = "birthday", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Birthday is mandatory")
    private Date birthday;

    @Column(name = "phone_number", nullable = false, length = 11)
    @NotBlank(message = "Phone Number is mandatory")
    @Size(max = 11, message = "Phone Number must be lest than 11 characters")
    private String phoneNumber;

    @Column(name = "email", nullable = false, length = 255)
    @NotBlank(message = "Email is mandatory")
    @Size(max = 255, message = "Email must be lest than 255 characters")
    private String email;

}