package com.rss.resurv.controller;

import com.rss.resurv.model.Reservation;
import com.rss.resurv.service.ReservationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ManagerReservationController {

    private ReservationService reservationService;

    public ManagerReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/manager_page")
    public String showCustomerReservations(Model model, HttpSession session) {
        List<Reservation> reservations = reservationService.findAllReservations();

        if(session.getAttribute("user_id") != null) {
            model.addAttribute("reservations", reservations);
            return "managerPage";
        }
        return "redirect:/managerLogin";
    }

//    @RequestMapping(value = "/myReservations/edit/{id}")
//    public String showEditReservationPage(@PathVariable Long id, Model model) {
//        model.addAttribute("id", id);
//        model.addAttribute("command", reservationService.findReservationById(id).orElse(null));
//        return "updateReservation";
//    }
//
//    @RequestMapping(value = "/myReservations/edit/{id}", method = RequestMethod.POST)
//    public String editReservation(@PathVariable Long id, @ModelAttribute("reservation") Reservation reservation) {
//        reservationService.updateReservation(id, reservation);
//        return "redirect:/myReservations";
//    }
//
//    @RequestMapping(value = "/myReservations/delete/{id}")
//    public String deleteReservation(@PathVariable Long id) {
//        reservationService.deleteById(id);
//        return "redirect:/myReservations";
//    }


}
