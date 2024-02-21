package ExamSubject1.PhamNgocDung.service;

import ExamSubject1.PhamNgocDung.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<EmployeeEntity> getAllEmployee();
    Optional<EmployeeEntity> getEmployeeById(String employeeId);
    void addEmployee (EmployeeEntity employee);
    void deleteEmployee (String employeeId);
    void updateEmployee();
}
