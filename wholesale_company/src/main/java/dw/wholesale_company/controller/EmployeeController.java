package dw.wholesale_company.controller;

import dw.wholesale_company.model.Employee;
import dw.wholesale_company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    // 선생님 코드:) 사원의 직위가 '사원'인 사람들 중에서 가장 최근에 입사한 사원의 정보
    @GetMapping("/employees/hiredate/latest")
    public ResponseEntity<Employee> getEmployeeByHireLatest() {
        return new ResponseEntity<>(employeeService.getEmployeeByHireLatest(),
                HttpStatus.OK);
    }
}
