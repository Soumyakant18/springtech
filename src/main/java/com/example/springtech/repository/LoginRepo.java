package com.example.springtech.repository;

import com.example.springtech.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login,Integer> {


    Optional<Login> findByUsername(String username);
}
