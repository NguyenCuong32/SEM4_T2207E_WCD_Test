package com.example.Test.controller;

import com.example.Test.entity.Employee;
import com.example.Test.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String List(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/formCreate")
    public String ViewCreate(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create";
    }

    @PostMapping("/create")
    public String Create(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/";
    }

}
