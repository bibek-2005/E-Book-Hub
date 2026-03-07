package com.example.BookStore.service;

import com.example.BookStore.entity.Cart;
import com.example.BookStore.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }
    public Cart addToCart(Cart cart){
        return cartRepository.save(cart);
    }
    public List<Cart> getAllCart(Long userid){
        return cartRepository.findAll();

    }
    public void  removeFromCart(Long id){
        cartRepository.deleteById(id);
        //return "Cart removed";
    }

}
