package org.example.baithith.controllers;

import org.example.baithith.models.Employee;
import org.example.baithith.service.EmployeeService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    @GetMapping("")
    public String getEmployee(Model model) {
        List<Employee> employees = employeeService.getAllEmployee();
        model.addAttribute("employees", employees);

        return "index";
    }

    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
    model.addAttribute("employees",new Employee());
        return "addEmployee";
    }

    @PostMapping("/add")
    public String addEmployee( @ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/";
        }

    @GetMapping("/editEmployee/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        Optional<Employee> employeeOptional = employeeService.getEmployeeById(id);
        if (employeeOptional.isPresent()){
            model.addAttribute("employeeOptional",employeeOptional.get());
            return "editEmployee";
        }else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee updateEmployee){
        employeeService.updateEmployee(id,updateEmployee);
        return "index";
    }


    @GetMapping("delete/{id}")
    public String deleteCategories(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
