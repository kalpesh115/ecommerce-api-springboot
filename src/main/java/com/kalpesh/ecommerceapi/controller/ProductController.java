package com.kalpesh.ecommerceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalpesh.ecommerceapi.entity.Product;
import com.kalpesh.ecommerceapi.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired ProductService service;

    @PostMapping("/admin")
    public Product add(@RequestBody Product p) {
        return service.add(p);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id) {
        return service.getById(id);
    }
}