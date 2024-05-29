package dw.jdbcproject.service;

import dw.jdbcproject.model.Member;
import dw.jdbcproject.repository.MemberRepository;
// import dw.jdbcproject.repository.jdbcMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
            //의존성 주입시 구현체를 사용하는 것이 아니라 인터페이스를 주입 받아야 한다.
            //약한 결합(인터페이스 주입)과 강한 결합(구현체 주입)
            //Jpa를 사용하자고 상황이 바뀌었을 때, 구현체 주입시 코드를 수정해야하지만 약한 결합시에는 코드 수정이 필요하지 않다.
    MemberRepository memberRepository;
    // jdbcMemberRepository jdbcMemberRepository; X 이유 : 강한 결합(구현체 주입)
    public Member saveMember(Member member){
        // repository save 넣는 자리
        return memberRepository.save(member);
    }

//    public ResponseEntity<List<Member>> findAllMember(){
//        return memberRepository.findAll();
//    }

    public Optional<Member> findById(long id){
        return memberRepository.findByIg(id);
    }
}
