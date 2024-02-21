package com.example.ExamTranThiMaiHien.DAO;

import com.example.ExamTranThiMaiHien.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeReponsitory extends JpaRepository<Employee,Integer> {


}
