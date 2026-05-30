//package com.kalpesh.ecommerceapi.repository;
//
//import com.kalpesh.ecommerceapi.entity.Cart;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.Optional;
//import java.util.List;
//
//public interface CartItemRepository extends JpaRepository<Cart, Long> {
//
//    Optional<Cart> findByUserId(Long userId);
//
//    List<Cart> findAllByUserId(Long userId);
//}