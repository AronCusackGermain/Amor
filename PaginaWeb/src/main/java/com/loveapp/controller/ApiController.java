package com.loveapp.controller;

import com.loveapp.model.LoveQuote;
import com.loveapp.service.LoveQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private LoveQuoteService loveQuoteService;
    
    @GetMapping("/quote/daily")
    public ResponseEntity<LoveQuote> getDailyQuote() {
        return ResponseEntity.ok(loveQuoteService.getDailyQuote());
    }
    
    @GetMapping("/quote/random")
    public ResponseEntity<LoveQuote> getRandomQuote() {
        return ResponseEntity.ok(loveQuoteService.getRandomQuote());
    }
}