package com.hr_manage.employee.service;

import com.hr_manage.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployee {
    List<Employee> getAllEmployee();
    Optional<Employee> getById(Integer id);
    void addNewEmployee(Employee employee);
    void updateEmployee();
    void deleteEmployee(Integer id);
}
