package com.example.Mars2;

import com.example.Mars2.login.JdbcTemplateMemberRepository;
import com.example.Mars2.login.MemberRepository;
import com.example.Mars2.register.JdbcTemplateRegisterRepository;
import com.example.Mars2.register.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberRepository memberRepository(){
        return new JdbcTemplateMemberRepository(dataSource);
    }

    @Bean
    public RegisterRepository registerRepository(){
        return new JdbcTemplateRegisterRepository(dataSource);
    }


}
