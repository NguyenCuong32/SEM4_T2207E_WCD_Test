package com.example.demoWDF.demo.service;


import com.example.demoWDF.demo.dto.ResponseData;
import com.example.demoWDF.demo.entity.employee;

import java.util.List;

public interface IEmployeeService {
    ResponseData addEmployee(employee employee);

    ResponseData deleteEmployee(String id);

    ResponseData updateEmployee(String id,employee employee);

    List<employee> findEmployeeByNameOrId(String name , String id);

    List<employee> findAll();
}
