package dw.gameshop.service;


import dw.gameshop.model.Games;
import dw.gameshop.repository.GameShopRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GameshopService {

    GameShopRepository gameShopRepository;

    public GameshopService(GameShopRepository gameShopRepository) {
        this.gameShopRepository = gameShopRepository;
    }

    public Games saveGames(@RequestBody Games games) {
        gameShopRepository.save(games);
        return games;
    }

    public List<Games> getAllGames() {
        return gameShopRepository.findAll();
    }

    public Games getGameById(@PathVariable long id) {
        Optional<Games> games = gameShopRepository.findById(id);
        if (games.isEmpty()) {
            return null;
        } else {
            return games.get();
        }
    }

    public Games updateGameById(@PathVariable long id, @RequestBody Games games) {
        Optional<Games> games1 = gameShopRepository.findById(id);
        if (games1.isPresent()) {
            games1.get().setTile(games.getTile());
            games1.get().setGenre(games.getGenre());
            games1.get().setPrice(games.getPrice());
            games1.get().setText(games.getText());

            gameShopRepository.save(games1.get());
            return games1.get();
        } else {
            return null;
        }
    }
}
