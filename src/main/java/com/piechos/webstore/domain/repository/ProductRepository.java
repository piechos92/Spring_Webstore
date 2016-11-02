package com.piechos.webstore.domain.repository;

import com.piechos.webstore.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByManufacturer(String manufacturer);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    Set<Product> getProductsByPriceFilter(BigDecimal low, BigDecimal high);

    void addProduct(Product product);
}
