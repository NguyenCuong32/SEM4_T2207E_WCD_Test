package com.example.demo11.controller;
import com.example.demo11.service.EmployeeService;
import com.example.demo11.entity.Employee;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@Controller
@RequestMapping("/employee")
public class EmployeeController {private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String GetEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employee", employees);
        return "employee/index";
    }

    @GetMapping("/formAdd")
    public String ShowFormAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/addNew";
    }
    @PostMapping("/save")
    public  String SaveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult , Model model){

        if (bindingResult.hasErrors()){
            return "employee/addNew";
        }
        employeeService.addNewEmployee(employee);
        return "redirect:/employee/list";
    }


    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("employeeId") long id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee.orElse(new Employee()));
        return "employee/addNew";
    }
    @GetMapping("/delete")
    public String DeleteEmployee(@RequestParam("employeeId") long id,Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}
