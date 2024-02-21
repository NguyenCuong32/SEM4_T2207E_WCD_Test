package com.example.demoWDF.demo.ViewController;

import com.example.demoWDF.demo.entity.employee;
import com.example.demoWDF.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class EmployeeViewController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String employee(Model model){
        List<employee> employee = employeeService.findAll();
        model.addAttribute("employees", employee);
        return "employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
}
