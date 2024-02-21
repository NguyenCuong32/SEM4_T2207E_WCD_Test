package com.t2207e.exam1.service;

import com.t2207e.exam1.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeService {
    List<Employee> getAllEmployee();
    Optional<Employee> getEmployeeById(String employeeId);
    void save(Employee employee);

    @Transactional
    void addEmployee(Employee employee);

    void updateEmployee();

    void deleteEmployee(String id);
}
