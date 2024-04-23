package dw.gameshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor  // 기본
@AllArgsConstructor // 생성자
@Getter
@Setter
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title", length = 65535)
    private String title;
    @Column(name = "genre")
    private String genre;
    @Column(name = "price")
    private int price;
    @Column(name = "image")
    private String image;
    @Column(name = "text")
    private  String text;


}
