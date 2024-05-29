package dw.wholesale_company.repository;

import dw.wholesale_company.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByOrderDate(LocalDate orderDate);

    //선생님코드 :) JPQL 설명 - Repository 참고
    //도시별로 주문금액합을 보이되 주문금액합이 많은 상위 5개의 도시에 대한 결과만 보이시오.
//    @Query("SELECT c.city, SUM(od.orderQuantity * od.unitPrice) AS totalOrderAmount FROM OrderDetail od JOIN od.order o JOIN o.customer c GROUP BY c.city ORDER BY totalOrderAmount DESC")
//    List<Object[]> getTopCitiesByTotalOrderAmount();
//
//    @Query("SELECT YEAR(o.orderDate), COUNT(o) FROM Order o WHERE o.customer.customerId IN (SELECT c.customerId  FROM Customer c  WHERE c.city = :city) GROUP BY YEAR(o.orderDate)")
//    List<Object[]> getOrderCountByYearForCity(@Param("city") String city);
}