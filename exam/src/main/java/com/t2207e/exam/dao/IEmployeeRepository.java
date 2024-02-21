package com.t2207e.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.t2207e.exam.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
