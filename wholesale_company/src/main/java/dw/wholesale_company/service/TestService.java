package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Employee;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.model.OrderDetail;
import dw.wholesale_company.repository.CustomerRepository;
import dw.wholesale_company.repository.EmployeeRepository;
import dw.wholesale_company.repository.OrderDetailRepository;
import dw.wholesale_company.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class TestService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    //1. 도시이름(city)을 매개변수로 받아 그 도시출신의 사원 정보를 보이시오.
    public List<Employee> getEmployeeByCity(String city) {
        List<Employee> employeeList = employeeRepository.findAll();
        List<Employee> employeesByCity = new ArrayList<>();

        for (int i = 0; i < employeeList.size(); i++) {
            String employeeCity = employeeList.get(i).getCity();
            if (employeeCity.equalsIgnoreCase(city)){
                employeesByCity.add(employeeList.get(i));
            }
        }
        return employeesByCity;
    }

    //2. 주문번호를 매개변수(orderId)로 받아 주문한 고객의 정보를 보이시오.
    public Customer getCustomerByOrderId(String orderId) {
        List<Order> orders = orderRepository.findAll();
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            if (order.getOrderId().equalsIgnoreCase(orderId)){
                return order.getCustomer();
            }
        }
        return null;
    }
        /*Optional<OrderDetail> orderDetailOptional = orderDetailRepository.findByOrderId(orderId);
        if (orderDetailOptional.isEmpty()) {
            return null;
        }

        OrderDetail orderDetail = orderDetailOptional.get();
        String customerId = String.valueOf(orderDetail.getOrderId().getCustomerId());

        if (customerId == null) {
            return null;
        }

        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer;
        }
        else {*/
    


    //3. 주문년도(orderYear)를 매개변수로 받아 그 해의 주문건수(int)를 보이시오.
    public int getOrderNumByOrderYear(int orderYear) {
        List<Order> orders = orderRepository.findAll();
        int count = 0;
        for (int i = 0; i < orders.size(); i++) {
            int orderByYear = orders.get(i).getOrderDate().getYear();
            if(orderByYear == orderYear){
                count++;
            }
        }
        return count;
    }

    //4. 직위(position)와 나이대(year)를 매개변수로 받아 해당정보에 맞는 사원들의 정보를 보이시오.
    // 예를 들어 20대는 매개변수 year=20 이고 나이가 20살이상 30살미만을 의미함.
    // 나이계산은 (올해 - 태어난해)로 계산.
    public List<Employee> getEmployeeByPositionAndYear(String position, int year) {
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> aa = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            int employeeYear = 2024 - employee.getBirthDate().getYear();
            employeeYear = employeeYear - (employeeYear%10);
            String employeePosition = employee.getPosition();
            if(position.contains(employeePosition) && year == employeeYear){
                    aa.add(employee);
                }
            }
        return aa;
    }
}