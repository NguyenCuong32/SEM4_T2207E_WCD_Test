package com.example.ExamTranThiMaiHien.service;

import com.example.ExamTranThiMaiHien.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(Integer id);
    void save(Employee employee);
    void deleteEmployee(Integer id);
}
