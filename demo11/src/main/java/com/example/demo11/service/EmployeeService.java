package com.example.demo11.service;
import com.example.demo11.dao.IEmployeeRepository;

import com.example.demo11.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    @Autowired


    private  IEmployeeRepository employeeRepostirory  ;



    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepostirory.findAll();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Optional<Employee> getEmployeeById(long id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public void addNewEmployee(Employee employee) {
        employeeRepostirory.save(employee);
    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee(long id) {
        employeeRepostirory.deleteById(id);

    }


}

