package com.example.Mars2.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "Login";
    }

    @PostMapping("/login")
    public String login(Member member){
        int a = memberService.login(member);
        if(a==0){
            return "redirect:/";
        }else {
            return "Main";
        }
    }
}
