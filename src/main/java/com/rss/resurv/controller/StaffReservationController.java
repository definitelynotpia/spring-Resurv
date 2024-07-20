package com.rss.resurv.controller;

import com.rss.resurv.model.Reservation;
import com.rss.resurv.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class StaffReservationController {

    private final ReservationService reservationService;

    public StaffReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/staff_page")
    public String showCustomerReservations(Model model, HttpSession session) {
        List<Reservation> reservations = reservationService.findAllReservations();

        if(session.getAttribute("user_id") != null) {
            model.addAttribute("reservations", reservations);
            return "staffPage";
        }
        return "redirect:/staffLogin";
    }
}
