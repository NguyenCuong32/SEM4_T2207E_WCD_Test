package com.example.Test.service;

import com.example.Test.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(String id);
    void save(Employee employee);
    void delete(String id);
}
