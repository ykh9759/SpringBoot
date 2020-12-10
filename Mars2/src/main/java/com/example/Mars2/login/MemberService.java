package com.example.Mars2.login;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public int login(Member member){
        Optional<Member> id = memberRepository.findById(member.getId());
        Optional<Member> pw = memberRepository.findByPw(member.getPw());
        if(id.isPresent() && pw.isPresent()){
            return member.getId();
        }else {
            System.out.println("아이디 또는 비밀번호를 확인해 주세요");
            return 0;
        }
    }
}
