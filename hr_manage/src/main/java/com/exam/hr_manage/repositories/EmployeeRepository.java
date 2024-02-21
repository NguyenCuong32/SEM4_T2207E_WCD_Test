package com.exam.hr_manage.repositories;

import com.exam.hr_manage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
