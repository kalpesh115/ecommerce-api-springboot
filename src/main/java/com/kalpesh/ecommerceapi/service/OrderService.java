package com.kalpesh.ecommerceapi.service;

import com.kalpesh.ecommerceapi.entity.Order;

public interface OrderService {
    Order placeOrder(Long userId);
}