package com.example.practialwcd.repostory;

import com.example.practialwcd.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findTopByOrderByEmployeeIdDesc();
}
