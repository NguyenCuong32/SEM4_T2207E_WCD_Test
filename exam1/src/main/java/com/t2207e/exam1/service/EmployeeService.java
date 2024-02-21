package com.t2207e.exam1.service;

import com.t2207e.exam1.dao.IEmployeeRepository;
import com.t2207e.exam1.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    private final IEmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String employeeId) {
        return Optional.empty();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee(String id) {

    }

}
