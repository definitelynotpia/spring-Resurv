package com.rss.resurv.controller;

import com.rss.resurv.model.Reservation;
import com.rss.resurv.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // get all Reservations
    @GetMapping("/myReservations")
    public String reservePage() { return "reserve"; }

    @RequestMapping(value = "/myReservations/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", reservationService.findById(id).orElse(null));
        return "updatecontact";
    }

    @RequestMapping(value = "/myReservations/edit/{id}", method = RequestMethod.POST)
    public String editReservation(@PathVariable Long id, @ModelAttribute("contact") Reservation reservation) {
        reservationService.updateReservation(id, reservation);
        return "redirect:/ReSurv/reservations";
    }

    @RequestMapping(value = "/myReservations/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
        return "redirect:/ReSurv/reservations";
    }
}
