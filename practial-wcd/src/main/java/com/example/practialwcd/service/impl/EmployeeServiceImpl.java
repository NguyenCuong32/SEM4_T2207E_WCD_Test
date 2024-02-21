package com.example.practialwcd.service.impl;

import com.example.practialwcd.entities.Employee;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceImpl {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployeeList();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(String employeeId);
}
