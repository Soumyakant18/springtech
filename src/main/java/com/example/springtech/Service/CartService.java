package com.example.springtech.Service;

import com.example.springtech.Entity.Cart;
import com.example.springtech.Repository.Repo;
import com.example.springtech.ResourceNotfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements CartService1{
    private Repo repo;
    private Integer cartId;

    @Autowired
    public CartService (Repo repo){
        this.repo = repo;
    }

    @Override
    public Cart saveCart(Cart cart) {
        return repo.save(cart);
    }

    @Override
    public List<Cart> getCart() {
        return repo.findAll();
    }

    @Override
    public Cart getCartById(Integer cartId) {
        Optional<Cart> cart = repo.findById(cartId);
        return cart.orElse(null);
    }

    @Override
    public Cart updateCart(Long cartId, Cart updatedCart) {
        return null;
    }




    @Override
    public Cart updateCart(Integer cartId, Cart updatedCart) {
        Optional<Cart> existingCartOptional = repo.findById(cartId);

        if (existingCartOptional.isPresent()) {
            Cart existingCart = existingCartOptional.get();

            // Update fields of existingCart with the values from updatedCart
            existingCart.setName(updatedCart.getName());
            existingCart.setDesc(updatedCart.getDesc());
            existingCart.setPrice(updatedCart.getPrice());

            // Save the updated cart
            return repo.save(existingCart);
        } else {
            throw new ResourceNotfoundException("cart", "id", cartId);
        }
    }

    @Override
    public void deleteCartById(Integer cartId) {
        this.cartId = cartId;
        Optional<Cart> cart = repo.findById(cartId);

        if (cart.isPresent()) {
            repo.delete(cart.get());
        } else {
            throw new ResourceNotfoundException("cart", "id", cartId);
        }
    }
}
