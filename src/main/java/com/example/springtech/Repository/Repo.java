package com.example.springtech.Repository;

import com.example.springtech.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository <Cart, Integer> {
}
