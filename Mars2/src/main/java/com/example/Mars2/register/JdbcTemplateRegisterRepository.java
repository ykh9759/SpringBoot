package com.example.Mars2.register;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcTemplateRegisterRepository implements RegisterRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateRegisterRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(Register register) {
        try {
            SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
            jdbcInsert.withTableName("projects").usingGeneratedKeyColumns("name");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("pname", register.getName());
            parameters.put("ptype", register.getType());
            parameters.put("pnum", register.getNum());
            parameters.put("part", register.getPart());
            parameters.put("pintroduce", register.getIntroduce());
            jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Register> findAll() {
        return jdbcTemplate.query("select * from projects" ,registerRowMapper());
    }

    private RowMapper<Register> registerRowMapper(){
        return (rs, rowNum) -> {
            Register register = new Register();
            register.setName(rs.getString("pname"));
            register.setType(rs.getString("ptype"));
            register.setNum(rs.getString("pnum"));
            register.setPart(rs.getString("part"));
            register.setIntroduce(rs.getString("pintroduce"));
            return register;
        };
    }
}
