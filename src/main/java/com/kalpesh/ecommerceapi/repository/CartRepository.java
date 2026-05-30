package com.kalpesh.ecommerceapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kalpesh.ecommerceapi.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUserId(Long userId);

    List<Cart> findAllByUserId(Long userId);

}