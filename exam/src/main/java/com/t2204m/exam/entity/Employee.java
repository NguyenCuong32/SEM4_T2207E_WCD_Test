package com.t2204m.exam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @NotNull(message = "Id is required")
    private String id;

    @NotNull(message = "Employee name is required")
    @Size(min = 2, message = "Employee name must be at least 2 characters")
    private String employee_name;

    @NotNull(message = "birthday is required")
    private LocalDate birthday;

    @NotNull(message = "Phone number is required")
    @Size(min = 10, max = 11, message = "Phone number must be between 10 and 11 characters")
    private String phone_number;

    @NotNull(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

}
