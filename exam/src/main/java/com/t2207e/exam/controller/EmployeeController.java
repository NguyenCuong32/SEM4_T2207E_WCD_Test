package com.t2207e.exam.controller;
import com.t2207e.exam.entity.Employee;
import com.t2207e.exam.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.StringBufferInputStream;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private  final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String getProducts(Model model){

        var employee = employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employee/index";
    }
    @GetMapping("/formAdd")
    public String ShowFormAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee/addNew";
    }

    @PostMapping("/save")
    public String SaveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "employee/addNew";
        }
        else {
            employeeService.addNewEmployee(employee);
            return "redirect:/employee/list";
        }
    }

    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("employeeId") Integer id, Model model) {
        Optional<Employee> employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee/addNew";
    }
    @GetMapping("delete")
    public String DeleteStudent(@RequestParam("employeeId") Integer id,Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }

}
