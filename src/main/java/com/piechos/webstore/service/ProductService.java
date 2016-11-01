package com.piechos.webstore.service;

import com.piechos.webstore.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);
}
