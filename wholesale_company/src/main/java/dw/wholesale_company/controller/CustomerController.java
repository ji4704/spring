package dw.wholesale_company.controller;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    //선생님 코드:)
    //고객 전체의 평균마일리지보다 평균마일리지가 큰 고객 정보
    @GetMapping("/customers/highmilethanavg")
    public ResponseEntity<List<Customer>> getCustomerWithHighMileThanAvg() {
        return new ResponseEntity<>(customerService.getCustomerWithHighMileThanAvg(),
                HttpStatus.OK);
    }

    //마일리지 등급명별로 고객수를 보이시오
    @GetMapping("customers/mileage/{grade}")
    public int getCustomerByMileageGrade(@PathVariable String grade) {
        return customerService.getCustomerByMileageGrade(grade);
    }

    /*//마일리지 등급명별로 고객수를 보이시오
    //선생님 코드
    @GetMapping("/customers/grade/{grade}")
    public ResponseEntity<List<Customer>> getCustomerByMileageGradeT(@PathVariable String grade) {
        return new ResponseEntity<>(customerService.getCustomerByMileageGradeT(grade),
                HttpStatus.OK);
    }*/
}
