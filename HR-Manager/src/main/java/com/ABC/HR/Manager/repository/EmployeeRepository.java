package com.ABC.HR.Manager.repository;

import com.ABC.HR.Manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
