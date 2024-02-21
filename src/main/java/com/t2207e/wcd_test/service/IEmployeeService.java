package com.t2207e.wcd_test.service;

import com.t2207e.wcd_test.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getEveryEmployees();
    Optional<Employee> getEmployeeById(int employeeid);
    void save(Employee employee);
    void updateEmployee();
    void deleteEmployee(Integer employeeid);
}
