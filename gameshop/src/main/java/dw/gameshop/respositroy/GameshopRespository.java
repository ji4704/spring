package dw.gameshop.respositroy;

import dw.gameshop.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

import java.util.List;

public interface GameshopRespository extends JpaRepository<Game, Long> {
    //Repository에서 JPQL 사용법 : @Query 어노테이션 사용
    @Query("SELECT g1 FROM Game g1 WHERE g1.price = (SELECT MAX(g2.price) FROM Game g2)")
    Game getGameWithMaxPrice();

    @Query("select g1 from Game g1 order by g1.price desc")
    public List<Game> getGameWithMaxPriceTop3();
}
