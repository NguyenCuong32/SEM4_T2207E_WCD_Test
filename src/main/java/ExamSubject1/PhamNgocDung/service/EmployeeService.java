package ExamSubject1.PhamNgocDung.service;

import ExamSubject1.PhamNgocDung.dao.IEmployeeRepository;
import ExamSubject1.PhamNgocDung.entity.EmployeeEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    private final IEmployeeRepository EmployeeRepository;
    public EmployeeService (IEmployeeRepository EmployeeRepository)
    {
        this.EmployeeRepository = EmployeeRepository;
    }
    @Override
    public List<EmployeeEntity> getAllEmployee()
    {
        return EmployeeRepository.findAll();
    }
    @Override
    public Optional<EmployeeEntity> getEmployeeById(String employeeId)
    {
        return EmployeeRepository.findById(employeeId);
    }
    @Override
    @Transactional
    public void addEmployee(EmployeeEntity employee)
    {
        EmployeeRepository.save(employee);
    }
    @Override
    public void deleteEmployee (String employeeId)
    {
        EmployeeRepository.deleteById(employeeId);
    }
    @Override
    public void updateEmployee()
    {

    }
}
