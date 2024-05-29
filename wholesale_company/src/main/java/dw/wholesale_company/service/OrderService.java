package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.model.OrderDetail;
import dw.wholesale_company.repository.OrderDetailRepository;
import dw.wholesale_company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    //과제:) 주문일이 2021년 5월 1일 이후인 주문 정보 얻기
    public List<Order> getOverDate(LocalDate date) {
        List<Order> orders = orderRepository.findAll();
        List<Order> overDate = new ArrayList<>();
        LocalDate pointData = date;
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            LocalDate checkDate = orders.get(i).getOrderDate();
            if (checkDate.isAfter(pointData)) {
                overDate.add(order);
            }
        }
        return overDate;
    }
    /*
    //선생님 코드:) 람다식
    //주문일이 2021년 5월 1일 이후인 주문 정보 얻기
    public List<Order> getOrderByDateAfter(LocalDate date) {
        List<Order> orders = orderRepository.findAll();
        //람다식(함수형 프로그래밍, 절차지향형프로그래밍)
        return orders.stream().filter(a -> a.getOrderDate().compareTo(date) > 0).collect(Collectors.toList());
    }
    */

    //2020년 4월 9일에 주문한 고객의 모든 정보을 보이시오.
    public List<Order> getOrderByDate(LocalDate date){
        List<Order> orders = orderRepository.findAll();
        List<Order> orderListByDate = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++) {
            if (date.equals(orders.get(i).getOrderDate())){
                orderListByDate.add(orders.get(i));
            }
        }
        return orderListByDate;
    }

    //선생님 코드:) 람다식
    //2020년 4월 9일에 주문한 고객의 모든 정보을 보이시오.
    public List<Customer> getCustomerByOrderDate(LocalDate orderDate) {
        List<Order> orders = orderRepository.findByOrderDate(orderDate);
        return orders.stream().map(order -> order.getCustomer()).collect(Collectors.toList());
    }

    //선생님코드 :) JPQL 설명 - Repository 참고
    //도시별로 주문금액합을 보이되 주문금액합이 많은 상위 5개의 도시에 대한 결과만 보이시오.
//    public List<Object[]> getTopCitiesByTotalOrderAmount(int limit) {
//        List<Object[]> cities = orderRepository.getTopCitiesByTotalOrderAmount();
//        return cities.stream().limit(limit).collect(Collectors.toList());
//    }

}
