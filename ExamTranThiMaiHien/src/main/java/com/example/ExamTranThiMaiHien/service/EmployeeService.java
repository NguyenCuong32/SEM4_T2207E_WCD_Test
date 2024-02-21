package com.example.ExamTranThiMaiHien.service;

import com.example.ExamTranThiMaiHien.DAO.IEmployeeReponsitory;
import com.example.ExamTranThiMaiHien.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private IEmployeeReponsitory employeeReponsitory;
    @Autowired
    public EmployeeService(IEmployeeReponsitory employeeReponsitory) {
        this.employeeReponsitory = employeeReponsitory;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeReponsitory.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeReponsitory.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeReponsitory.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeReponsitory.deleteById(id);
    }
}
