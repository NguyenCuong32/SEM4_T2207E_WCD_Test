package com.hr_manage.employee.service;

import com.hr_manage.employee.dao.IEmployeeDao;
import com.hr_manage.employee.entity.Employee;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements IEmployee  {
    private final IEmployeeDao employee;


    public EmployeeService(IEmployeeDao iEmployeeDao) {
        this.employee = iEmployeeDao;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employee.findAll();
    }

    @Override
    public Optional<Employee> getById(Integer id) {
        return employee.findById(id);
    }

    @Override
    @Transactional
    public void addNewEmployee(Employee employee) {
        employee.save(employee);
    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee(Integer id) {
        employee.deleteById(id);
    }


}
