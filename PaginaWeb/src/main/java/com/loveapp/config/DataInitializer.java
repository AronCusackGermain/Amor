package com.loveapp.config;

import com.loveapp.model.LoveQuote;
import com.loveapp.model.Memory;
import com.loveapp.repository.LoveQuoteRepository;
import com.loveapp.repository.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private LoveQuoteRepository loveQuoteRepository;
    
    @Autowired
    private MemoryRepository memoryRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Inicializar frases de amor si no existen
        if (loveQuoteRepository.count() == 0) {
            String[] quotes = {
                "Eres la razón por la que creo en el amor verdadero. 💕",
                "Cada día contigo es una nueva aventura llena de amor. 🌟",
                "Tu amor es mi lugar favorito en todo el universo. 🌌",
                "Eres mi sueño hecho realidad y mi realidad favorita. ✨",
                "Tu sonrisa es mi medicina favorita para cualquier día malo. 😊",
                "Contigo, el amor no es solo un sentimiento, es un hogar. 🏠",
                "Eres la poesía que mi corazón siempre quiso escribir. 📝",
                "Tu amor hace que incluso los lunes se sientan como viernes. 🎉",
                "Eres mi persona favorita en este mundo y en cualquier otro. 🌍",
                "Tu amor es la música que hace bailar a mi alma. 🎵",
                "Eres la respuesta a preguntas que ni sabía que tenía. 💫",
                "Tu amor es mi superpoder favorito. 💪",
                "Eres mi lugar seguro en este mundo tan loco. 🛡️",
                "Tu amor es como Cinnamoroll: dulce, tierno y perfecto. 🐰",
                "Eres la estrella más brillante en mi cielo. ⭐",
                "Tu amor es mi combustible para conquistar el mundo. 🚀",
                "Eres mi historia de amor favorita. 📚",
                "Tu amor es mi definición de perfección. 💎",
                "Eres la luz que guía todos mis caminos. 🌟",
                "Tu amor es mi mayor tesoro. 💰"
            };
            
            for (String quote : quotes) {
                loveQuoteRepository.save(new LoveQuote(quote));
            }
        }
    }
}