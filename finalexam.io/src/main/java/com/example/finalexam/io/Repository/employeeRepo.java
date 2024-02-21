package com.example.finalexam.io.Repository;

import com.example.finalexam.io.Entity.employee;
import org.springframework.data.repository.CrudRepository;

public interface employeeRepo  extends CrudRepository<employee, String> {
}
