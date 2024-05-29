package dw.gameshop.controller;

import dw.gameshop.model.Game;
import dw.gameshop.model.Purchase;
import dw.gameshop.model.User;
import dw.gameshop.service.GameshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
////@CrossOrigin( origins = "주소 넣는 곳")
//@CrossOrigin( origins = "http://127.0.0.1:5500/")
public class GameShopController {
    GameshopService gameshopService;

    @Autowired
    public GameShopController(GameshopService gameshopService) {
        this.gameshopService = gameshopService;
    }

    @PostMapping("products")
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        return new ResponseEntity<>(gameshopService.saveGame(game), HttpStatus.OK);
    }

    @GetMapping("products")
    public ResponseEntity<List<Game>> getAllGames() {
        return new ResponseEntity<>(gameshopService.getAllGames(), HttpStatus.OK);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable long id) {
        return new ResponseEntity<>(gameshopService.getGameById(id), HttpStatus.OK);
    }

    @PutMapping("products/{id}")
    public ResponseEntity<Game> updateGamesById(@PathVariable long id, @RequestBody Game game) {
        return new ResponseEntity<>(gameshopService.updateGamesById(id, game), HttpStatus.OK);
    }

    //유저 파트
    @PostMapping("product/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(gameshopService.saveUser(user), HttpStatus.OK);
    }
    //제일 비싼 게임의 정보 - 자바에서 해결하는 방법
    @GetMapping("product/maxprice")
    public ResponseEntity<Game> getGameWithMaxPrice(){
        return new ResponseEntity<>(gameshopService.getGameWithMaxPrice(),HttpStatus.OK);
    }
    @GetMapping("product/maxpricetop3")
    public ResponseEntity<List <Game>> getGameWithMaxPriceTop3(){
        return new ResponseEntity<>(gameshopService.getGameWithMaxPriceTop3(),HttpStatus.OK);
    }
}
