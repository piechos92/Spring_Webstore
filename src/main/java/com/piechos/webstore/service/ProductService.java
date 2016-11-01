package com.piechos.webstore.service;

import com.piechos.webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByManufacturer(String manufacturer);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Set<Product> getProductsByPriceFilter(Map<String, List<String>> priceParams);
}
