package com.rss.resurv.controller;

import com.rss.resurv.model.Reservation;
import com.rss.resurv.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // get all Reservations
    @GetMapping("/myReservations")
    public String showReservationsPage(Model model, HttpSession session) {
        if(session.getAttribute("user_id") != null) {
            model.addAttribute("reservations", reservationService.findAllReservations());
            return "myReservations";
        }
        session.invalidate();
        return "redirect:/";

    }

    @RequestMapping(value = "newReservation")
    public String showNewReservationPage(Model model) {
        model.addAttribute("command", new Reservation());
        return "newReservation";
    }

    @RequestMapping(value = "/myReservations/edit/{id}")
    public String showEditReservationPage(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("command", reservationService.findReservationById(id).orElse(null));
        return "updateReservation";
    }

    @RequestMapping(value = "reserve", method = RequestMethod.POST)
    public String createReservation(@ModelAttribute("reservation") Reservation reservation, HttpSession session) {
        Long user_id = (Long) session.getAttribute("user_id");
        reservationService.saveReservation(reservation, user_id);
        return "redirect:/myReservations";
    }


    @RequestMapping(value = "/myReservations/edit/{id}", method = RequestMethod.POST)
    public String editReservation(@PathVariable Long id, @ModelAttribute("reservation") Reservation reservation) {
        reservationService.updateReservation(id, reservation);
        return "redirect:/myReservations";
    }

    @RequestMapping(value = "/myReservations/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
        return "redirect:/myReservations";
    }
}
