package dw.jdbcproject.repository;

import dw.jdbcproject.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class jdbcMemberRepository implements MemberRepository {
    // MemberRepository(인터페이스)의 구현체
    // 인터페이스를 상속받은 클래스 = 구현체
    // implement method를 누르면 자동 완성

    //Data에 관련한 메소드를 가지고 있다.
    @Autowired
    DataSource dataSource;

    @Override
    public Member save(Member member) {
        String sql = "insert into members(name) values(?)";
        // 아래 3개는 SQL 패키지 내의 클래스 정의
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = DataSourceUtils.getConnection(dataSource);
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, member.getName());
            pstmt.executeUpdate();
            resultSet = pstmt.getGeneratedKeys();
            //resultSet = 테이블의 한 로(한 줄)
            if(resultSet.next()) {
                member.setId(resultSet.getLong(1));
            } else {
                throw new SQLException("ID 조회 실패");
            }
            return member;
        } catch (Exception e) {
            // 예외 처리
            throw new IllegalStateException(e);
        } finally {
            // 연결 종료
            close(connection,pstmt,resultSet);
        }
    }

    @Override
    public Optional<Member> findByIg(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from members";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = DataSourceUtils.getConnection(dataSource);
            pstmt = connection.prepareStatement(sql);
            pstmt.executeQuery();
            List<Member> members = new ArrayList<>();
            while(resultSet.next()){
                Member member = new Member();
                member.setId(resultSet.getLong(1));
                member.setName(resultSet.getNString(2));
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(connection,pstmt,resultSet);
        }
    }

    private void  close(Connection connection,PreparedStatement pstmt, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null)
                pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
