package com.example.prctice1.repository;

import com.example.prctice1.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login,Integer> {


    Optional<Login> findByUsername(String username);
}
