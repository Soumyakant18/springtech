package com.example.springtech.repository;

import com.example.springtech.entity.Laptop;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
    // You can add custom query methods here if needed
}
