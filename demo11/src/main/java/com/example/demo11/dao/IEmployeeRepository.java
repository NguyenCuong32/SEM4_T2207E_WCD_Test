package com.example.demo11.dao;
import com.example.demo11.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
