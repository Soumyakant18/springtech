package com.example.springtech.repository;

import com.example.springtech.entity.Headphone;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface HeadphoneRepository extends JpaRepository<Headphone, Long> {
    // You can add custom query methods here if needed
}
