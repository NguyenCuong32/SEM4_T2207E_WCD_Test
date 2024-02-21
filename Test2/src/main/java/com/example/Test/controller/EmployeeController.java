package com.example.Test.controller;

import com.example.Test.entity.Employee;
import com.example.Test.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/formEdit/{id}")
    public String ViewEdit(Model model, @PathVariable String id){
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employeeOptional.get());
        return "edit";
    }
    @PostMapping("edit/{id}")
    public String Edit(@ModelAttribute Employee employee, @PathVariable String id){
        employeeService.save(employee);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable String id){
        employeeService.delete(id);
        return "redirect:/";
    }

}
