package com.exam.hr_manage.service;

import com.exam.hr_manage.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(String employeeId);
    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteCountry(String id);
}
