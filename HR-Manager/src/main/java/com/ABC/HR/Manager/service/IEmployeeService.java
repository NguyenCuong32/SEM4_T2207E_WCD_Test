package com.ABC.HR.Manager.service;

import com.ABC.HR.Manager.model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(int id);
    void save(Employee employee);
    void deleteById(Integer id);
}
