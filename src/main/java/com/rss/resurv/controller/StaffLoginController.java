package com.rss.resurv.controller;

import com.rss.resurv.model.Customer;
import com.rss.resurv.model.Staff;
import com.rss.resurv.service.StaffLoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffLoginController {

    @Autowired
    private StaffLoginService staffLoginService;

    @GetMapping("/staff_login")
    public String staffLoginPage() {
        return "staffLogin";
    }

    @GetMapping("/staff_page")
    public String staffHomePage(HttpSession session) {
        if(session.getAttribute("user_id") == null) {
            return "redirect:/staff_login";
        } else {
            return "staffPage";
        }
    }

    @PostMapping("/staffLogin")
    public ModelAndView staffValidateLogin(HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String result = staffLoginService.validateLogin(email, password);

        Staff staff = staffLoginService.findStaffByEmail(email);

        if (result.equals("Login successful")) {
            session.setAttribute("user_id", staff.getUser_id());
            modelAndView.setViewName("redirect:/staff_page");
            return modelAndView;
        } else {
            modelAndView.setViewName("redirect:/staff_login");
            return modelAndView;
        }
    }

    @RequestMapping(value = "staff_logout", method = RequestMethod.GET)
    public String staffLogout(HttpSession session) {
        if(session.getAttribute("user_id") != null) {
            session.invalidate();
            return "redirect:/staff_login";
        }
        return "redirect:/staff_login";

    }

}
