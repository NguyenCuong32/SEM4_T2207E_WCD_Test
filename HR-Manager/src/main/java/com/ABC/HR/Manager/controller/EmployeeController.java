package com.ABC.HR.Manager.controller;

import com.ABC.HR.Manager.model.Employee;
import com.ABC.HR.Manager.repository.EmployeeRepository;
import com.ABC.HR.Manager.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initbinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String GetListTrees(Model model){
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employee",employees);
        return "employee/index";
    }

    @GetMapping("/add")
    public String CreateTree(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee/add";
    }

    @PostMapping("/add")
    public String AddEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "employee/add";
        }else {
            employeeService.save(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/editForm/{id}")
    public String ViewEditEmployee(@PathVariable Integer id, Model model){
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("emploee", employee);
        return "employee/edit";
    }

    @PostMapping("/edit")
    public String editTree(@ModelAttribute Employee employee){
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteTree(@PathVariable Integer id){
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
}
