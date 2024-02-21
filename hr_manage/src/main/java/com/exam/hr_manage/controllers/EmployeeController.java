package com.exam.hr_manage.controllers;

import com.exam.hr_manage.entity.Employee;
import com.exam.hr_manage.service.EmployeeService;
import com.exam.hr_manage.service.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public String getEmployee(Model model){
        List<Employee> listEmployee = employeeService.getAllEmployee();
        model.addAttribute("listEmployee",listEmployee);
        return "pages/listEmployee";
    }
    @GetMapping("/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "pages/addEmployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/admin/list";
    }


}
