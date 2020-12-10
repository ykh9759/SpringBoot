package com.example.Mars2.login;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateMemberRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Member> findById(int id){
        List<Member> result = jdbcTemplate.query("select * from user where id = ?",memberRowMapper(),id);
        System.out.println(result);
        return result.stream().findAny();
    }

    @Override
    public Optional<Member> findByPw(int pw){
        List<Member> result = jdbcTemplate.query("select * from user where pw = ?",memberRowMapper(),pw);
        System.out.println(result);
        return result.stream().findAny();
    }
    private RowMapper<Member> memberRowMapper() {
        return (rs, rowNum) -> {
            Member Member = new Member();
            Member.setId(rs.getInt("id"));
            Member.setPw(rs.getInt("pw"));
            return Member;
        };
    }
}
