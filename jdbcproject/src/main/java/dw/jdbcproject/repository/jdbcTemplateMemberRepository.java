package dw.jdbcproject.repository;

import dw.jdbcproject.JdbcprojectApplication;
import dw.jdbcproject.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;


//차이점 : 반복되는 작업을 빼준다.
//단점 : SQL이 수백개가 필요한데 관리가 어렵다. -> 한 곳에서 관리하는 방식 : Mybatis
@Repository
//구현체가 여러개일때 @Primary 를 붙여서 이 구현체가 기본값이라고 알려줌
//구현체에 붙이지 않고 메서드 마다 붙이는 방법도 있다.
@Primary
public class jdbcTemplateMemberRepository implements MemberRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Member save(Member member) {
        //비추천
//        jdbcTemplate.update("insert into members(name) values(?)", member.getName());
//        return  member;
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement("insert into members(name) values(?)",
                            Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, member.getName());
                    return ps;
                }, keyHolder);
        member.setId(keyHolder.getKey().longValue());
        return member;
    }

    @Override
    public Optional<Member> findByIg(Long id) {
        return jdbcTemplate.query("select * from members where id = ?", memberRowMapper(), id).stream().findFirst();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return jdbcTemplate.query("select * from members where name = ?", memberRowMapper(), name).stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return jdbcTemplate.query("select * from members", memberRowMapper());
    }

    private RowMapper<Member> memberRowMapper() {
        //memberRowMapper = 익명 함수를 리턴한다.
        //함수형태로 돌려준다. = 방법을 리턴한다. (물고기를 리턴하는게 아니라 물고기 잡는 방법을 알려준다.)
        return (rs, rowNum) -> {
            Member member = new Member();
            member.setId(rs.getLong(1));
            member.setName(rs.getString(2));
//            member.setName(rs.getNString(1));
            return member;
        };
    }
}
