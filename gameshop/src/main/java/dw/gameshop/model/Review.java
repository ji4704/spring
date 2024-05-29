package dw.gameshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.lang.model.element.Modifier;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "point", nullable = false)
    private int point;
    @Column(name = "review_txet", length = 65535)
    private String reviewText;
    // LocalDateTime createdAt  한 번 생성되고 건들지 않는다.
    // insertable = false 값을 받아주지 않겠다.(SQL)
    //updatable = false 값을 절대 수정할 수 없다.
    @Column(name = "created_at",  updatable = false)
    private LocalDateTime createdAt;
//    @Column(name = "modifier_at")
//    private Modifier modifierAt;
}
