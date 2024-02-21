package ExamSubject1.PhamNgocDung.controller;

import ExamSubject1.PhamNgocDung.entity.EmployeeEntity;
import ExamSubject1.PhamNgocDung.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
    @GetMapping("/List")
    public String getListEmployee (Model model)
    {
        List<EmployeeEntity> listEmployee = service.getAllEmployee();
        model.addAttribute("ListEmployee", listEmployee);
        return "/employee/index";
    }
    @GetMapping("/formAdd")
    public String ShowFormAdd(Model model) {
        EmployeeEntity employee = new EmployeeEntity();
        model.addAttribute("EmployeeNew", employee);
        return "employee/addNew";
    }
    @PostMapping("/save")
    public String SaveEmployee(@Valid @ModelAttribute("Employee") EmployeeEntity SaveEmployee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employee/addNew";
        } else {
            service.addEmployee(SaveEmployee);
            return "redirect:/employee/List";
        }
    }

}
