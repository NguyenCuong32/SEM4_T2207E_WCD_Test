package com.t2204m.exam.controller;

import com.t2204m.exam.entity.Employee;
import com.t2204m.exam.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    public String index(Model model) {
        List<Employee> employeeList = employeeService.getEmployeeList();
        model.addAttribute("employees", employeeList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @PostMapping("/create-process")
    public String createProcess(
            @ModelAttribute("employee") @Valid Employee employee,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        employeeService.createEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return "redirect:/";
    }
}
