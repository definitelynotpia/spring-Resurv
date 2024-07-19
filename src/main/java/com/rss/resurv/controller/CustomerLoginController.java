package com.rss.resurv.controller;

import com.rss.resurv.model.Customer;
import com.rss.resurv.service.CustomerLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String loginPage() { return "index"; }

    @GetMapping("/home")
    public String homePage(HttpSession session, HttpServletRequest request) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/";
        } else {
            return "home";
        }
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

    @PostMapping("/login")
    public ModelAndView validateLogin(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String result = customerLoginService.validateLogin(email, password);

//        String result = customerLoginService.validateLogin(request.getParameter("email"), request.getParameter("password"));
        Customer customer = customerLoginService.findCustomerByEmail(email);
        if (result.equals("welcome")) {
            session.setAttribute("user_id", customer.getUser_id());
            modelAndView.setViewName("redirect:/home");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        if(session.getAttribute("user_id") != null) {
            session.invalidate();
            return "redirect:/";
        }
        return "redirect:/home";

    }
}
