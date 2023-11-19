package com.example.springtech.repository;

import com.example.springtech.entity.Watch; // Replaced Headphone with Watch
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional

public interface WatchRepository extends JpaRepository<Watch, Long> { // Replaced Headphone with Watch
    // You can add custom query methods here if needed
}
