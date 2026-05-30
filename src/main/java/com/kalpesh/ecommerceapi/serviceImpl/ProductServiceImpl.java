package com.kalpesh.ecommerceapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalpesh.ecommerceapi.entity.Product;
import com.kalpesh.ecommerceapi.repository.ProductRepository;
import com.kalpesh.ecommerceapi.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired ProductRepository repo;

    @Override
	public Product add(Product p) {
        return repo.save(p);
    }



    @Override
	public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		 return repo.findAll();
	}



}