package com.example.rematch.service;

import com.example.rematch.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(Integer id);
    void addNewEmployee(Employee student);
    void updateEmployee();
    void deleteEmployee(Integer id);
}
