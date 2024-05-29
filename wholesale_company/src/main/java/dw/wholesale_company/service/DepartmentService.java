package dw.wholesale_company.service;

import dw.wholesale_company.model.Department;
import dw.wholesale_company.repository.DepartmentRepository;
import org.hibernate.dialect.DerbyDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    // 자주 사용하기 때문에 쓸때마다 new 키워드를 사용해서 만드는게 아니라 의존성 주입을 통해 빈 형태로 만들어 계속 사용할 수 있게 한다
    // error code : departmentRepository is null = 의존성 주입이 없기 때문에 findAll()이라는 메소드를 찾을 수 없어 -> 해서 null이라고 보냄

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
