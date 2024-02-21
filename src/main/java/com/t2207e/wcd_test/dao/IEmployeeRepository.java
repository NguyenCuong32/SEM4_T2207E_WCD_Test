package com.t2207e.wcd_test.dao;

import com.t2207e.wcd_test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
