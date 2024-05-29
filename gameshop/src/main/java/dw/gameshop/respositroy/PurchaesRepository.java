package dw.gameshop.respositroy;

import dw.gameshop.model.Purchase;
import dw.gameshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaesRepository extends JpaRepository<Purchase, Long> {
    //JPA method 명명법에 의거하여 올바른 작명을 해야 한다.
    //스펙에 명시된 명명법을 제대로 따르기만 한다면 JPA가 스펙의 규칙대로 구동한다.
    List<Purchase> findByUser(User user);
}
