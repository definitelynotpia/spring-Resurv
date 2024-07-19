package com.rss.resurv.controller;

import com.rss.resurv.model.Customer;
import com.rss.resurv.service.CustomerRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerRegisterController {

    @Autowired
    private CustomerRegisterService customerRegisterService;

//    @PostMapping("user/register")
    @RequestMapping(value = "result", method = RequestMethod.POST)
    public ModelAndView registerCustomer(HttpServletRequest request) {

        //Extracting Data From HttpServletRequest to DTO
        Customer customerRegister = new Customer();
        customerRegister.setFirstName(request.getParameter("fname"));
        customerRegister.setLastName(request.getParameter("lname"));
        customerRegister.setEmail(request.getParameter("email"));
        customerRegister.setPassword(request.getParameter("password"));

        String result = customerRegisterService.CustomerRegister(customerRegister);

        ModelAndView modelAndView = new ModelAndView();
        //setting result jsp file name
        modelAndView.setViewName("result");
        modelAndView.addObject("message", result);

        return modelAndView;
    }

}
