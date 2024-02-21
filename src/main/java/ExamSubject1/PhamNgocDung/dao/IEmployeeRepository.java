package ExamSubject1.PhamNgocDung.dao;

import ExamSubject1.PhamNgocDung.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}
