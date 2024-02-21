package com.example.demoWDF.demo.repository;

import com.example.demoWDF.demo.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface employeeRepository extends JpaRepository<employee,String> {
    List<employee> findByEmployeeNameOrEmployeeId(String name, String id);
}
