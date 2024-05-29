package dw.jdbcproject.controller;

import dw.jdbcproject.model.Member;
import dw.jdbcproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/member/new")
    public ResponseEntity<Member> saveMember(@RequestBody Member member){
        //방법1
        return ResponseEntity.ok(memberService.saveMember(member));
        //방법2
        //return new ResponseEntity<>(memberService.saveMember(member), HttpStatus.OK);

    }
    @GetMapping("/member/{id}")
    public ResponseEntity<Optional<Member>> findById(@PathVariable long id){
        return ResponseEntity.ok(memberService.findById(id));
    }

//    @GetMapping("member/find/all")
//    public ResponseEntity<List<Member>> findAllMember(){
//        return ResponseEntity<>(memberService.findAllMember(), HttpStatus.OK);
//    }
}
