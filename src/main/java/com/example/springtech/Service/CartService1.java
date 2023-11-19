package com.example.springtech.Service;

import com.example.springtech.Entity.Cart;

import java.util.List;

public interface CartService1 {
    Cart saveCart (Cart cart);

   List<Cart>getCart();
    Cart getCartById(Integer cartId);

    Cart updateCart(Long cartId, Cart updatedCart);

    void deleteCartById(Integer cartId);


    Cart updateCart(Integer cartId, Cart updatedCart);


}
