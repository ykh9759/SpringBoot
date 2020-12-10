package com.example.Mars2.login;

import java.util.Optional;

public interface MemberRepository {
    Optional<Member> findById(int id);
    Optional<Member> findByPw(int pw);
}
