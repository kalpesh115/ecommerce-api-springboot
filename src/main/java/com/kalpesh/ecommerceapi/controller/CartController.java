package com.kalpesh.ecommerceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kalpesh.ecommerceapi.entity.Cart;
import com.kalpesh.ecommerceapi.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired CartService service;

    @PostMapping("/add")
    public Cart add(@RequestParam Long userId,
                    @RequestParam Long productId,
                    @RequestParam int qty) {
        return service.addToCart(userId, productId, qty);
    }

    @GetMapping
    public Cart get(@RequestParam Long userId) {
        return service.getCart(userId);
    }
    @DeleteMapping("/remove")
    public Cart remove(@RequestParam Long userId,
                       @RequestParam Long productId) {
        return service.removeFromCart(userId, productId);
    }
}