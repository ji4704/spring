package dw.gameshop.service;

import dw.gameshop.expection.ResourceNotFoundException;
import dw.gameshop.model.Game;
import dw.gameshop.model.User;
import dw.gameshop.respositroy.GameshopRespository;
import dw.gameshop.respositroy.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameshopService {

    GameshopRespository gameshopRespository;
    //유저파트
    UserRepository userRespository;

    public GameshopService(GameshopRespository gameshopRespositoty, UserRepository userRespository) {
        this.gameshopRespository = gameshopRespositoty;
        this.userRespository = userRespository;
    }

    public Game saveGame(Game game) {
        gameshopRespository.save(game);
        return game;
    }

    public List<Game> getAllGames() {
        return gameshopRespository.findAll();
    }

    public Game getGameById(@PathVariable long id) {
        Optional<Game> game = gameshopRespository.findById(id);
        if (game.isEmpty()) {
            throw new ResourceNotFoundException("Gameshop", "ID", id);
        } else {
            return game.get();
        }
    }

    public Game updateGamesById(@PathVariable long id, Game game) {
        Optional<Game> game1 = gameshopRespository.findById(id);
        if (game1.isPresent()) {
            game1.get().setTitle(game.getTitle());
            game1.get().setGenre(game.getGenre());
            game1.get().setPrice(game.getPrice());
            game1.get().setText(game.getText());

            gameshopRespository.save(game1.get());
            return game1.get();
        } else {
            throw new ResourceNotFoundException("Gameshop", "ID", id);
        }
    }

    public User saveUser(User user) {
        return userRespository.save(user);
    }

    //제일 비싼 게임의 정보 - 자바에서 해결하는 방법
    public Game getGameWithMaxPrice() {
        List<Game> games = gameshopRespository.findAll();
        //람다식이 아닌 일반 자바 코드 사용 예
//        if(games.size() <= 0) {
//            throw new ResourceNotFoundException("Max price"," "," ");
//        }
//        Game max = games.get(0);
//        for (int i = 0; i < games.size()-1; i++) {
//            if (max.getPrice() < games.get(i+1).getPrice()){
//                max = games.get(i+1);
//            }
//        }
//        return max;
        //람다식 사용 예
//        return games.stream()
//                .sorted(Comparator.comparingInt(Game::getPrice)
//                        .reversed())
//                .findFirst()
//                .orElseThrow(() -> new ResourceNotFoundException("Max price", " ", " "));
        //JPQL 사용 예
        return gameshopRespository.getGameWithMaxPrice();
    }

    //제일 비싼 게임 top3
    public List<Game> getGameWithMaxPriceTop3() {
        List<Game> games = gameshopRespository.findAll();
        //sort 사용하기
        //람다식 표현법
        //sort 사용법은 외워야한다.
//        games.sort(Comparator.comparingInt((Game game) -> game.getPrice()).reversed()); //comparingInt는 익명함수를 써야한다.
//        // :: 오름차순 -> reversed = 내림차순 :: 변수가 누구껀지 알려줘야해서 (Game game)이라고 써야한다.
//        List<Game> newGames = new ArrayList<>();
//        for (int i = 0; i < 3; i++){
//            newGames.add(games.get(i));
//        }
//        return newGames;
//        return games.stream()
//                .sorted(Comparator.comparingInt(Game::getPrice).reversed())
//                .limit(3)
//                .collect(Collectors.toList()); //stream 형태를 자료구조형 List 로 바꿔주는 코드
        return gameshopRespository.getGameWithMaxPriceTop3().stream().limit(3).collect(Collectors.toList());
    }
}




