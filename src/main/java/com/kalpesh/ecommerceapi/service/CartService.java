package com.kalpesh.ecommerceapi.service;

import com.kalpesh.ecommerceapi.entity.Cart;

public interface CartService {
    Cart addToCart(Long userId, Long productId, int qty);
    Cart getCart(Long userId);
    Cart removeFromCart(Long userId, Long productId);
}