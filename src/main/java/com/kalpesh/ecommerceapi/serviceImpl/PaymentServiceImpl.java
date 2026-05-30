package com.kalpesh.ecommerceapi.serviceImpl;

import org.springframework.stereotype.Service;

import com.kalpesh.ecommerceapi.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String checkout(Long userId) {

        // Normally Stripe API call happens here
        return "Payment session created for user " + userId;
    }
}