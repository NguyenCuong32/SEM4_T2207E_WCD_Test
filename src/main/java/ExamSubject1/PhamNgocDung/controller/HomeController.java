package ExamSubject1.PhamNgocDung.controller;

import ExamSubject1.PhamNgocDung.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private final EmployeeService service;

    public HomeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping("/")
    public String Index (Model model)
    {
        return "employee/index";
    }
}
