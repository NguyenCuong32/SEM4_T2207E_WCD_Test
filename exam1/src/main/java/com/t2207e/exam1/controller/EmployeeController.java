package com.t2207e.exam1.controller;

import com.t2207e.exam1.entity.Employee;
import com.t2207e.exam1.service.EmployeeService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/list")
    public String EmployeeService(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @PostMapping("/save")
    public String SaveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/students/list";
    }

    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("employeeId") String id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee/addNew";
    }
    @GetMapping("delete")
    public String DeleteEmployee(@RequestParam("employeeId") String id,Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}
