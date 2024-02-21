package com.t2204m.exam.controller;

import com.t2204m.exam.entity.Employee;
import com.t2204m.exam.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/v1/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public String getEmployees(Model model){

        Iterable<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee/index";
    }

    @GetMapping("/add")
    public String showFormAddEmployee(Model model){
        model.addAttribute("newEmployee", new Employee());
        return "employee/add";
    }

    @PostMapping("/add")
    public String saveEmployee(@Valid @ModelAttribute("newEmployee") Employee newEmployee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "employee/add";
        } else {
            employeeService.addNewEmployee(newEmployee);
            return "redirect:/v1/employees";
        }

    }

    @GetMapping("/edit")
    public String getEmployee (@RequestParam("employeeId") String id, Model model){
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        employee.ifPresent(value -> model.addAttribute("updateEmployee", value));
        return "employee/update";
    }

    @PostMapping("/update")
    public String updateEmployee (@ModelAttribute("updateEmployee") Employee updateEmployee){
        employeeService.updateEmployee(updateEmployee.getId(), updateEmployee);
        return "redirect:/v1/employees";
    }


    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") String id){
        employeeService.deleteEmployee(id);
        return "redirect:/v1/categories";
    }


}
