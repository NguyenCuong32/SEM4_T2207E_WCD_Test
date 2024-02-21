package com.example.Test.dao;

import com.example.Test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
}
