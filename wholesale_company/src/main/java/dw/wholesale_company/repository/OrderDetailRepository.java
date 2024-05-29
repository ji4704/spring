package dw.wholesale_company.repository;

import dw.wholesale_company.model.Order;
import dw.wholesale_company.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    //Optional<OrderDetail> findByOrderId(String orderId);
}