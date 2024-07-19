package com.rss.resurv.controller;

import com.rss.resurv.service.CustomerLoginService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerLoginController {

    @Autowired
    private CustomerLoginService customerLoginService;

    //Default Page
    @GetMapping("/")
    public String loginPage() {
        return "index";
    }

    //Redirect to Customer Registration
    @RequestMapping(value = "registerPage", method = RequestMethod.POST)
    public String registerPage() {
        return "newCustomer";
    }

    //Redirect to Login Page
    @RequestMapping(value = "backToLogin", method = RequestMethod.POST)
    public String backToLoginPage() {
        return "redirect:/";
    }

//    Commented this out because its not working. Need to hardcode POST like this instead.
    @PostMapping("/login")
//    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView validateLogin(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        String result = customerLoginService.validateLogin(request.getParameter("email"), request.getParameter("password"));
        if (!result.equals("welcome")) {
            modelAndView.setViewName("index");
            modelAndView.addObject("message", result);
            return modelAndView;
        } else {
            modelAndView.setViewName("home");
            modelAndView.addObject("message", result);
            return modelAndView;
        }


    }
}
