package com.rss.resurv.controller;

import com.rss.resurv.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/customer_reservations")
    public String showCustomerReservations(Model model, HttpSession session) {
        if(session.getAttribute("user_id") != null) {
            model.addAttribute("reservations", reservationService.findAllReservations());
            return "myReservations";
        }
        return "redirect:/staffLogin";
    }
}
