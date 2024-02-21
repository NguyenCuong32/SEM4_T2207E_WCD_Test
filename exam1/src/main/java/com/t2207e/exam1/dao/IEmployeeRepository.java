package com.t2207e.exam1.dao;

import com.t2207e.exam1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,String> {
}
