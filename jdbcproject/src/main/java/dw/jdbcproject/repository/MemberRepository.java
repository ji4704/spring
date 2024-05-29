package dw.jdbcproject.repository;

import dw.jdbcproject.model.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //jpa가 존재하지 않음으로 직접 만들어야 한다.
    Member save(Member member);
    Optional<Member> findByIg(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
