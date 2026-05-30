package com.kalpesh.ecommerceapi.service;

import com.kalpesh.ecommerceapi.dto.LoginRequest;
import com.kalpesh.ecommerceapi.dto.RegisterRequest;

public interface AuthService {
    String register(RegisterRequest request);
    String login(LoginRequest request);
}