package dw.gameshop.controller;

import dw.gameshop.model.Games;
import dw.gameshop.service.GameshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameShopController {
    @Autowired
    GameshopService gameshopService;

    @PostMapping("/product")
    public Games saveGames(@RequestBody Games games){
        return gameshopService.saveGames(games);
    }
    @GetMapping("/product")
    public List<Games> getAllGames(){
        return gameshopService.getAllGames();
    }
    @GetMapping("/product/{id}")
    public Games getGameById(@PathVariable long id){
        return gameshopService.getGameById(id);
    }
    @PutMapping("/product/{id}")
    public Games updateGameById(@PathVariable long id, @RequestBody Games games){
        return gameshopService.updateGameById(id, games);
    }
}
