package dw.gameshop.service;

import dw.gameshop.expection.ResourceNotFoundException;
import dw.gameshop.model.Purchase;
import dw.gameshop.model.User;
import dw.gameshop.respositroy.PurchaesRepository;
import dw.gameshop.respositroy.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PurchaseService {

    @Autowired
    PurchaesRepository purchaesRepository;
    @Autowired
    UserRepository userRespository;
    public Purchase savePurchase(Purchase purchase){
        //구매확정 바로 직전, 현재시간을 저장함
        purchase.setPurchaseTime(LocalDateTime.now());
        purchaesRepository.save(purchase);
        return purchase;
    }
    public List<Purchase> getAllPurchase() {
        return purchaesRepository.findAll();
    }
    public List<Purchase> getPurchaseListByUser(String userId) {
        // 유저아이디로 유저객체 찾기
        Optional<User> userOptional = userRespository.findByUserId(userId);  //구글링 : Jpa 메서드규칙
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User", "ID", userId);
        }
        return purchaesRepository.findByUser(userOptional.get());
    }
    //유저 이름으로 구매한 게임 이름 찾기
    public List<Purchase> getPurchaseListByUserName(String userName) {
        //유저객체 찾기
        Optional<User> userOptional = userRespository.findByUserName(userName);

        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User", "Name", userName);
        }
        return purchaesRepository.findByUser(userOptional.get());  //지금과 같이 객체로 찾는 경우도 있다.
    }

}
