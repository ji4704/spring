package dw.firstapp.repository;

import dw.firstapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//이 파일에 SQL에 들어는 명령어들이 사용된다.
// SQL과 service를 분리한다.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
