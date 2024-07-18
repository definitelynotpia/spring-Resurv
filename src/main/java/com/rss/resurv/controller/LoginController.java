package com.rss.resurv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "index";
    }

    @PostMapping("/login")
    public String homePage(ModelMap model, @RequestParam String email, @RequestParam String password){
        if (email.equals("test@mail.com") && password.equals(("root"))){
            return "home";
        }
        model.put("errorMsg", "Incorrect user credentials!");
        return "index";
    }

}
