package dw.wholesale_company.controller;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.OrderRepository;
import dw.wholesale_company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("orders")
    public ResponseEntity<List<Order>> getAllOrder() {
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    // 과제:) 주문일이 2021년 5월 1일 이후인 주문 정보 얻기
    @GetMapping("orders/date/after/{date}")
    public ResponseEntity<List<Order>> getOverDate(@PathVariable LocalDate date) {
        return new ResponseEntity<>(orderService.getOverDate(date), HttpStatus.OK);
    }
    /*
    // 선생님 코드:) 주문일이 2021년 5월 1일 이후인 주문 정보 얻기
    @GetMapping("/orders/date/after/{date}")
    public ResponseEntity<List<Order>> getOrderByDateAfter(@PathVariable LocalDate date) {
        return new ResponseEntity<>(orderService.getOrderByDateAfter(date),
                HttpStatus.OK);
    }
    */

    //2020년 4월 9일에 주문한 고객의 모든 정보을 보이시오.
    @GetMapping("orders/info/by/{date}")
    public ResponseEntity<List<Order>> getOrderByDate(@PathVariable LocalDate date) {
        return new ResponseEntity<>(orderService.getOrderByDate(date), HttpStatus.OK);
    }

    //선생님 코드:) 람다식
    //2020년 4월 9일에 주문한 고객의 모든 정보을 보이시오.
    @GetMapping("/orders/orderdate/{orderDate}")
    public ResponseEntity<List<Customer>> getCustomerByOrderDate(@PathVariable LocalDate orderDate) {
        return new ResponseEntity<>(orderService.getCustomerByOrderDate(orderDate),
                HttpStatus.OK);
    }
    //선생님코드 :) JPQL 설명 - Repository 참고
    //도시별로 주문금액합을 보이되 주문금액합이 많은 상위 5개의 도시에 대한 결과만 보이시오.
//    @GetMapping("/orders/city/orderamount/{limit}")
//    public ResponseEntity<List<Object[]>> getTopCitiesByTotalOrderAmount(@PathVariable int limit) {
//        return new ResponseEntity<>(orderService.getTopCitiesByTotalOrderAmount(limit),
//                HttpStatus.OK);
//    }


}