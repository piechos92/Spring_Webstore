package com.piechos.webstore.service.impl;

import com.piechos.webstore.domain.Product;
import com.piechos.webstore.domain.repository.ProductRepository;
import com.piechos.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }
}
