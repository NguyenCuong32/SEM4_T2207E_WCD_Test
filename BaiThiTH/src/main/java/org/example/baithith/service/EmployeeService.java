package org.example.baithith.service;

import org.example.baithith.models.Employee;
import org.example.baithith.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    public List<Employee> getAllEmployee() {

        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    public Employee saveEmployee(Employee employee) {
        return  employeeRepository.save(employee);
    }
    public Employee updateEmployee(Long id, Employee updateEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setEmployeeId(updateEmployee.getEmployeeId());
            employee.setEmployeeName(updateEmployee.getEmployeeName());
            employee.setBirthday(updateEmployee.getBirthday());
            employee.setPhoneNumber(updateEmployee.getPhoneNumber());
            employee.setEmail(updateEmployee.getEmail());
            return employeeRepository.save(employee);
        }else {
            return  null;
        }
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
