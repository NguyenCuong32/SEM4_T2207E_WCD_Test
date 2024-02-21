package com.example.ExamTranThiMaiHien.controller;

import com.example.ExamTranThiMaiHien.entity.Employee;
import com.example.ExamTranThiMaiHien.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("list")
    public String GetList(Model model){
        List<Employee> employeeList=employeeService.getAllEmployee();
        model.addAttribute("employeeList",employeeList);
        return "employee/index";
    }
    @GetMapping("create")
    public String CreateEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employee/create";
    }
    @PostMapping("save")
    public String SaveEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult ){
        if(bindingResult.hasErrors() ){
            return "employee/create";
        }
        employeeService.save(employee);
        return "redirect:list";
    }
    @GetMapping("update/{id}")
    public String UpdateEmployee(Model model, @PathVariable Integer id ){
        Optional<Employee> employee=employeeService.getEmployeeById(id);
        model.addAttribute("employee",employee);
        return "employee/update";
    }
    @GetMapping("delete")
    public String DeleteEmployee(@RequestParam("id") Integer id,Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }

}
