package dw.gameshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
//LomBok
@NoArgsConstructor  //기본생성자
@AllArgsConstructor //생성자
@Setter // 게터
@Getter // 세터
// 개발단계에서는 사용하다가 비지니스레벨로 배포 전 테스트 시 지우고 수기로 작성
// Entity에서만 사용 가능
@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "purchase_time")
    private LocalDateTime purchaseTime;
}
