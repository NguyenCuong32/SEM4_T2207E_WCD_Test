package com.t2204m.exam.service;

import com.t2204m.exam.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getEmployeeList();

    Employee updateEmployee(Employee employee);

    void deleteEmployee(String employeeId);
}
