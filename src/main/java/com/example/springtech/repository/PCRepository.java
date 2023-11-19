package com.example.springtech.repository;

import com.example.springtech.entity.PC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCRepository extends JpaRepository<PC, Long> {
}
