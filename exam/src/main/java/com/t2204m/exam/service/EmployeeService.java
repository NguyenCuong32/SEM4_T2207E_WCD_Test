package com.t2204m.exam.service;

import com.t2204m.exam.dao.IEmployeeRepository;
import com.t2204m.exam.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class EmployeeService implements IEmployeeService{

    private final IEmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(String id, Employee employee) {
        Optional<Employee> existedEmployee = employeeRepository.findById(id);
        if(existedEmployee.isPresent()){
            Employee newEmployee = existedEmployee.get();
            newEmployee.setId(employee.getId());
            newEmployee.setEmployee_name(employee.getEmployee_name());
            newEmployee.setBirthday(employee.getBirthday());
            newEmployee.setPhone_number(employee.getPhone_number());
            newEmployee.setEmail(employee.getEmail());

            employeeRepository.save(newEmployee);
        } else {
            employee.setId(id);
            employeeRepository.save(employee);
        }
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
