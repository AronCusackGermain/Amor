package com.loveapp.controller;

import com.loveapp.service.LoveQuoteService;
import com.loveapp.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @Autowired
    private MemoryService memoryService;
    
    @Autowired
    private LoveQuoteService loveQuoteService;
    
    @GetMapping("/feliz-cumple")
    public String cumple() {
        return "feliz-cumple";
    }
}
