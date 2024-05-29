package dw.jdbcproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Member {
    private long id;
    private String name;
}

//jsbc를 사용하면 수많은 테이블을 직접 DBeaver에서 작성 해야한다.

