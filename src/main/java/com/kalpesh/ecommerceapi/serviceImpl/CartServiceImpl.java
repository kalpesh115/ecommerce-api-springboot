package com.kalpesh.ecommerceapi.serviceImpl;

import org.springframework.stereotype.Service;

import com.kalpesh.ecommerceapi.entity.Cart;
import com.kalpesh.ecommerceapi.entity.CartItem;
import com.kalpesh.ecommerceapi.repository.CartRepository;
import com.kalpesh.ecommerceapi.service.CartService;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart addToCart(Long userId, Long productId, int qty) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart c = new Cart();
                    c.setUserId(userId);
                    return c;
                });

        for (CartItem item : cart.getItems()) {
            if (item.getProductId().equals(productId)) {
                item.setQuantity(item.getQuantity() + qty);
                return cartRepository.save(cart);
            }
        }

        CartItem newItem = new CartItem();
        newItem.setProductId(productId);
        newItem.setQuantity(qty);
        newItem.setCart(cart);

        cart.getItems().add(newItem);

        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    @Override
    public Cart removeFromCart(Long userId, Long productId) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        cart.getItems().removeIf(i -> i.getProductId().equals(productId));

        return cartRepository.save(cart);
    }
}