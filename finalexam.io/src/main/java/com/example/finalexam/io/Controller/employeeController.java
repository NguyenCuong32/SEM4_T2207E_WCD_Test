package com.example.finalexam.io.Controller;

import com.example.finalexam.io.Entity.employee;
import com.example.finalexam.io.Repository.employeeRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/api")
public class employeeController {
    @Autowired
    employeeRepo employeerepo;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    //lay danh sach
    @GetMapping("/list")
    public String getList(Model model){

        var Std = employeerepo.findAll();
        //hiện thị lên view
        // model.addAttribute("studentlist",1);
        model.addAttribute("studentlist",Std);
        return "employee/index";
    }
    @GetMapping("/formAddNew")
    public String AddNewStd(employee employee){

        return "employee/formAddNew";
    }

    @PostMapping("/adduser")

    public String addUser(@Valid @ModelAttribute("student") employee employee, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "employee/formAddNew";
        } else {
            employeerepo.save(employee);
            return "redirect:list";}
    }
    @GetMapping("/edit/{id}")
    public String showUpdate(@PathVariable("id") String employeeId, Model model)
    {
        employee employee = employeerepo.findById(employeeId)
                .orElseThrow(()-> new IllegalArgumentException("cant find ID " + employeeId));
        model.addAttribute("student",employee);
        return "employee/updateuser";
    }
    @PostMapping("/update/{id}")
    public String changeUser(@PathVariable("id") String employeeId, @Valid employee employee,
                             BindingResult result, Model model){
        if (result.hasErrors()) {
            employee.setEmployeeId(employeeId);
            return "employee/updateuser";
        }
        else {
             //nếu id là auto increment
            employeerepo.save(employee);
            return "redirect:api/list";}
    }

    @GetMapping("/del/{id}")
    public String deluser(@PathVariable("id") String employeeId, Model model){
        employee employee = employeerepo.findById(employeeId)
                .orElseThrow(() -> new IllegalArgumentException("Cant find id" + employeeId));
        employee.setEmployeeId(employeeId);
        employeerepo.delete(employee);
        return "redirect:api/list";
    }
}
