package com.example.springtech.Controller;

import com.example.springtech.Entity.Cart;
import com.example.springtech.ResourceNotfoundException;
import com.example.springtech.Service.CartService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//public class CartController {
//    private CartService1 cartService1;
//
//    @Autowired
//    public CartController(CartService1 cartService1) {
//        this.cartService1 = cartService1;
//    }
//
//    @PostMapping("/api/cart")
//    public ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {  // Add @RequestBody annotation
//        return new ResponseEntity<>(cartService1.saveCart(cart), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/api/getAll")
//    public List<Cart> getAllCart() {
//        return cartService1.getCart();
//    }
//
//
//
//
//}
@RestController
@RequestMapping("/api/carts") // Set a common base path for all endpoints
public class CartController {

    private final CartService1 cartService1;

    @Autowired
    public CartController(CartService1 cartService1) {
        this.cartService1 = cartService1;
    }

    @PostMapping("/add") // Changed the endpoint to be more RESTful
    public ResponseEntity<Cart> saveCart(@RequestBody Cart cart) {
        return new ResponseEntity<>(cartService1.saveCart(cart), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<Cart> getAllCarts() {
        return cartService1.getCart();
    }

    @GetMapping("/get/{id}") // Endpoint to get a cart by ID
    public ResponseEntity<Cart> getCartById(@PathVariable("id") Integer cartId) {
        Cart cart = cartService1.getCartById(cartId);

        if (cart != null) {
            return new ResponseEntity<>(cart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable("id") Integer cartId, @RequestBody Cart updatedCart) {
        Cart existingCart = cartService1.getCartById(cartId);

        if (existingCart != null) {
            // Update fields of existingCart with the values from updatedCart
            existingCart.setName(updatedCart.getName());
            existingCart.setDesc(updatedCart.getDesc());
            existingCart.setPrice(updatedCart.getPrice());

            // Save the updated cart
            Cart savedCart = cartService1.saveCart(existingCart);

            return new ResponseEntity<>(savedCart, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable("id") Integer cartId) {
        try {
            cartService1.deleteCartById(cartId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ResourceNotfoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
