package com.example.demoWDF.demo.controller;

import com.example.demoWDF.demo.dto.ResponseData;
import com.example.demoWDF.demo.entity.employee;
import com.example.demoWDF.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/api/v1/findEmployee")
    public List<employee> findStudent(@RequestParam String name , @RequestParam String id){
       return employeeService.findEmployeeByNameOrId(name, id);
    }

    @PostMapping("/api/v1/employee")
    public ResponseEntity<ResponseData> addStudent(@RequestBody employee employee){
        ResponseData responseData = employeeService.addEmployee(employee);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
    @PutMapping("/api/v1/employee/{id}")
    public ResponseEntity<ResponseData> updateStudent(@PathVariable String id,@RequestBody employee employee){
        ResponseData responseData = employeeService.updateEmployee(id,employee);
        return ResponseEntity.status(responseData.getStatus()).body(responseData);
    }
}
