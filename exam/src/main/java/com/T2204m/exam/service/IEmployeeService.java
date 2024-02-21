package com.T2204m.exam.service;

import com.T2204m.exam.Entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    void addNewEmployee(Employee employee);

    Optional<Employee> findEmployeeById(String id);

    void updateEmployee(String id, Employee student);

    void deleteEmployee(String id);
}