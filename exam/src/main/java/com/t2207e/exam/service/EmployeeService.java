package com.t2207e.exam.service;
import com.t2207e.exam.entity.Employee;
import com.t2207e.exam.dao.IEmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepostirory;

    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepostirory) {
        this.employeeRepostirory = employeeRepostirory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepostirory.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepostirory.findById(id);
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
    public void deleteEmployee(Integer id) {
        employeeRepostirory.deleteById(id);
    }
}