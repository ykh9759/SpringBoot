package com.example.Mars2.home;

import com.example.Mars2.register.Register;
import com.example.Mars2.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final RegisterService registerService;

    public HomeController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/main/home")
    public String showHome(){

        return "home";
    }

    @GetMapping("/main/list")
    public String showList(Model model){
        List<Register> list = registerService.findList();
        model.addAttribute("list", list);
        return "List";
    }

    @GetMapping("/list/register")
    public String showRegister(){
        return "register";
    }

    @GetMapping("/register")
    public String register(Register register,Model model){
        registerService.save(register);
        List<Register> list = registerService.findList();
        model.addAttribute("list", list);
        return "List";
    }
}
