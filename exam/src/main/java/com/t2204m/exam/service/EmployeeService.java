package com.t2204m.exam.service;

import com.t2204m.exam.entity.Employee;
import com.t2204m.exam.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
// Determine the current year
        int currentYear = LocalDate.now().getYear();

        // Get the last employee ID from the database and extract the sequence number
        Optional<Employee> lastEmployee = employeeRepository.findTopByOrderByEmployeeIdDesc();
        int sequenceNumber = 1; // Default sequence number if no employee found

        if (lastEmployee.isPresent()) {
            String lastEmployeeId = lastEmployee.get().getEmployeeId();
            sequenceNumber = Integer.parseInt(lastEmployeeId.substring(5)) + 1;
        }

        // Generate the new employee ID
        String newEmployeeId = currentYear + "A" + sequenceNumber;

        // Set the generated employee ID to the employee object
        employee.setEmployeeId(newEmployeeId);

        // Save the employee to the database
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public void deleteEmployee(String employeeId) {

    }
}
