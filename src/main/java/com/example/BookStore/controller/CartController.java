package com.example.BookStore.controller;


import com.example.BookStore.entity.Cart;
import com.example.BookStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping()
    public Cart addToCart(@RequestBody Cart cart){
        return cartService.addToCart(cart);
    }
    @DeleteMapping("/{id}")
    public String  removeFromCart(@PathVariable Long id){
        cartService.removeFromCart(id);
        return "Cart removed";
    }
    @GetMapping("/user/{userid}")
    public List<Cart> getAllCarts(@PathVariable Long userId){
        return cartService.getAllCart(userId);
    }

}
