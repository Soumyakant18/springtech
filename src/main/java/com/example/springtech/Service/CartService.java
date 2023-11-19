package com.example.springtech.Service;

import com.example.springtech.Entity.Cart;
import com.example.springtech.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService implements CartService1{
    private Repo repo;
    @Autowired
    public CartService (Repo repo){
        this.repo = repo;
    }

    @Override
    public Cart saveCart(Cart cart) {
        return repo.save(cart);
    }
}
