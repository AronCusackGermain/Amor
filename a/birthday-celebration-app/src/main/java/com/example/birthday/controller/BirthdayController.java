package com.example.birthday.controller;

import com.example.birthday.model.Guest;
import com.example.birthday.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BirthdayController {

    @Autowired
    private GuestRepository guestRepository;

    @GetMapping("/birthday")
    public String showBirthdayPage(Model model) {
        List<Guest> guests = guestRepository.findAll();
        model.addAttribute("guests", guests);
        return "birthday";
    }

    @PostMapping("/birthday/addGuest")
    public String addGuest(@RequestParam String name, @RequestParam String message) {
        Guest guest = new Guest();
        guest.setName(name);
        guest.setMessage(message);
        guestRepository.save(guest);
        return "redirect:/birthday";
    }
}