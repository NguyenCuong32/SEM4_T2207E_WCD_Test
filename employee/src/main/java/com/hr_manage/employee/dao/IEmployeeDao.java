package com.hr_manage.employee.dao;

import com.hr_manage.employee.entity.Employee;
import com.hr_manage.employee.service.IEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeDao extends JpaRepository<Employee, Integer> {
}
