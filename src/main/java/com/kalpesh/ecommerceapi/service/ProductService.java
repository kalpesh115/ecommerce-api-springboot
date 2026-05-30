package com.kalpesh.ecommerceapi.service;

import java.util.List;

import com.kalpesh.ecommerceapi.entity.Product;

public interface ProductService {
    Product add(Product p);
    List<Product> getAll();
    Product getById(Long id);
}