package dw.gameshop.resposition;

import dw.gameshop.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameShopRespository extends JpaRepository<Games, Long> {
}
