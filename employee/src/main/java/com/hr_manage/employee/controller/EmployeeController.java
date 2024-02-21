package com.hr_manage.employee.controller;

import com.hr_manage.employee.entity.Employee;
import com.hr_manage.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String GetEmployee(Model model){
        List<Employee> employee = employeeService.getAllEmployee();
        model.addAttribute("employee", employee);
        return "Employee/list";
    }

    @GetMapping("/add")
    public String FormAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "Employee/create";
    }

    @PostMapping("/save")
    public String SaveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "Employee/create";
        }else {
            employeeService.addNewEmployee(employee);
            return "redirect:/Employee/list";
        }
    }

    @GetMapping("update")
    public String FormUpdate(@RequestParam("employeeId") Integer id, Model model){
        Optional<Employee> employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "Employee/create";
    }
    @GetMapping("delete")
    public String DeleteEmployee(@RequestParam("employeeId") Integer id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/Employee/list";
    }
}
