package dw.firstapp.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;

@Entity // 데이터베이스와 매핑 시키기 위함
@Table(name = "employees") // 괄호안의 내용을 테이블로 만든다.
public class Employee {
    @Id // 프라이머키로 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호 매기기
    private long id; // integer로 할 경우 범위를 초과할 수 있으므로 long을 사용

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
