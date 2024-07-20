package com.rss.resurv.controller;

import com.rss.resurv.model.Manager;
import com.rss.resurv.model.Staff;
import com.rss.resurv.service.ManagerLoginService;
import com.rss.resurv.service.StaffLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerLoginController {

    @Autowired
    private ManagerLoginService managerLoginService;

    @GetMapping("/manager_login")
    public String adminLoginPage() {
        return "managerLogin";
    }

    @GetMapping("/managerHomePage")
    public String staffHomePage(HttpSession session, Model model) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/manager_login";
        } else {
            return "managerPage";
        }
    }

    @PostMapping("/managerLogin")
    public ModelAndView staffValidateLogin(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String result = managerLoginService.validateLogin(email, password);

        Manager manager = managerLoginService.findManagerByEmail(email);

        if (result.equals("Login successful")) {
            session.setAttribute("user_id", manager.getUser_id());
            modelAndView.setViewName("redirect:/manager_page");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/manager_login");
            return modelAndView;
        }
    }

    @RequestMapping(value = "manager_logout", method = RequestMethod.GET)
    public String staffLogout(HttpSession session) {
        if(session.getAttribute("user_id") != null) {
            session.invalidate();
            return "redirect:/manager_login";
        }
        return "redirect:/manager_login";

    }

}
