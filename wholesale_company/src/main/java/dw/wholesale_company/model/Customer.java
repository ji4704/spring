package dw.wholesale_company.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.event.SpringApplicationEvent;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "고객")
public class Customer {
    @Id
    @Column(name = "고객번호")       // generatedValue - 숫자일때 자동으로 번호를 입력받기 위해서 사용하는 어노테이션
    private String customerId;     // Table Colum 명은 사용자가 보는것이기 때문에 한글 사용이 가능하지만, 변수는 프로그램 내에서 개발자가 사용하는 것이므로 영어로 사용.
    @Column(name = "고객회사명")
    private String customerName;
    @Column(name = "담당자명")
    private String customerEmployee;
    @Column(name = "담당자직위")
    private String customerTitle;
    @Column(name = "주소")
    private String address;
    @Column(name = "도시")
    private String city;
    @Column(name = "지역")
    private String area;
    @Column(name = "전화번호")
    private String phoneNumber;
    @Column(name = "마일리지")
    private Long mileage;
}
