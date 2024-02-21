package com.example.demo11.service;
import com.example.demo11.entity.Employee;
import com.example.demo11.entity.Employee;

import  java.util.List;
import java.util.Optional;
public interface IEmployeeService {
    List<Employee> getAllEmployee();

    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
    void addNewEmployee(Employee employee);
    void updateEmployee();
    void deleteEmployee(long id);
}
