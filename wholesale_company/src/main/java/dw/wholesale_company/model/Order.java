package dw.wholesale_company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "주문")
public class Order {
    @Id
    @Column(name = "주문번호")
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "고객번호")
    private Customer customer;              //  Customer : 외래키로 사용되고 있는 엔티티클래스의 타입을 데이터타입으로 사용한다. 변수명은 보통 객체의 소문자를 사용한다. = customer
    @ManyToOne
    @JoinColumn(name = "사원번호")
    private Employee employee;
    @Column(name = "주문일")
    private LocalDate orderDate;
    @Column(name = "요청일")
    private LocalDate requestData;
    @Column(name = "발송일")
    private LocalDate shippingData;

}
