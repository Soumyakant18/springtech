package com.example.springtech.Controller;

import com.example.springtech.Entity.Cart;
import com.example.springtech.Service.CartService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    private CartService1 cartService1;

   @Autowired
    public CartController(CartService1 cartService1){
        this.cartService1=cartService1;
    }

    @PostMapping("/api/cart")
    public ResponseEntity<Cart> saveCart(Cart cat){
       return new ResponseEntity<Cart>(cartService1.saveCart(cat), HttpStatus.CREATED);
    }
}
