package com.example.Mars2.register;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {
    private RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository){
        this.registerRepository = registerRepository;
    }

    public String save(Register register){
        registerRepository.save(register);
        return register.getName();
    }

    public List<Register> findList(){
        return registerRepository.findAll();
    }
}
