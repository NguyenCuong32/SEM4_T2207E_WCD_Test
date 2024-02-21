package com.t2207e.exam.service;
import com.t2207e.exam.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(Integer id);
    void addNewEmployee(Employee employee);
    void updateEmployee();
    void deleteEmployee(Integer id);
}