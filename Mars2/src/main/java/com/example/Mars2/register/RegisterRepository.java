package com.example.Mars2.register;

import java.util.List;

public interface RegisterRepository {
    void save(Register register);
    List<Register> findAll();
}
