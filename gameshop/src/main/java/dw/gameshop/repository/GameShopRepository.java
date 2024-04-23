package dw.gameshop.repository;

import dw.gameshop.model.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameShopRepository extends JpaRepository<Games, Long> {
}
