package com.loveapp.repository;

import com.loveapp.model.LoveQuote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoveQuoteRepository extends JpaRepository<LoveQuote, Long> {
    @Query(value = "SELECT * FROM love_quotes ORDER BY RAND() LIMIT 1", nativeQuery = true)
    LoveQuote findRandomQuote();
}