package com.loveapp.service;

import com.loveapp.model.LoveQuote;
import com.loveapp.repository.LoveQuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LoveQuoteService {
    
    @Autowired
    private LoveQuoteRepository loveQuoteRepository;
    
    public LoveQuote getDailyQuote() {
        List<LoveQuote> quotes = loveQuoteRepository.findAll();
        if (quotes.isEmpty()) {
            return new LoveQuote("Eres mi amor eterno 💕");
        }
        
        // Usar el día del año para obtener una frase consistente cada día
        int dayOfYear = LocalDate.now().getDayOfYear();
        int index = dayOfYear % quotes.size();
        return quotes.get(index);
    }
    
    public LoveQuote getRandomQuote() {
        LoveQuote quote = loveQuoteRepository.findRandomQuote();
        return quote != null ? quote : new LoveQuote("Eres mi amor eterno 💕");
    }
    
    public List<LoveQuote> getAllQuotes() {
        return loveQuoteRepository.findAll();
    }
    
    public LoveQuote saveQuote(LoveQuote quote) {
        return loveQuoteRepository.save(quote);
    }
}
