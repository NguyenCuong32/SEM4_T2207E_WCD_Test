package com.t2207e.wcd_test.controllers;

import com.t2207e.wcd_test.entity.Employee;
import com.t2207e.wcd_test.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String ListEmployee(Model model) {
        var employees = employeeService.getEveryEmployees();
        model.addAttribute("employees", employees);
        return "/employee/list";
    }
    @GetMapping("/addNewEmployee")
    public String AddNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "/employee/addnew";
    }
    @PostMapping("/save")
    public String AddNewEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "employee/addNew";
        }else{
            employeeService.save(employee);
            return "redirect:/list";
        }
    }
    @GetMapping("/update")
    public String ShowFormUpdate(@RequestParam("employeeid") Integer employeeid, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(employeeid);
        model.addAttribute("employee",employee);
        return "employee/addnew";
    }
    @GetMapping("/delete")
    public String DeleteEmployee(@RequestParam("employeeid") Integer employeeid,Model model) {
        employeeService.deleteEmployee(employeeid);
        return "redirect:/employee/list";
    }
}
