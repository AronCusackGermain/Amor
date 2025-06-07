package com.loveapp.repository;

import com.loveapp.model.Memory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemoryRepository extends JpaRepository<Memory, Long> {
    List<Memory> findAllByOrderByDateDesc();
    List<Memory> findTop10ByOrderByCreatedAtDesc();
}