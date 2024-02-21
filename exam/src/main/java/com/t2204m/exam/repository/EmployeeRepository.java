package com.t2204m.exam.repository;

import com.t2204m.exam.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findTopByOrderByEmployeeIdDesc();
}
