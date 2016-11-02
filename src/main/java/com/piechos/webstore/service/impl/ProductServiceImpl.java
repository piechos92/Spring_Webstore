package com.piechos.webstore.service.impl;

import com.piechos.webstore.domain.Product;
import com.piechos.webstore.domain.repository.ProductRepository;
import com.piechos.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsByManufacturer(String manufacturer) {
        return productRepository.getProductsByManufacturer(manufacturer);
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return productRepository.getProductsByFilter(filterParams);
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, List<String>> priceParams) {
        BigDecimal low = new BigDecimal(priceParams.get("low").get(0));
        BigDecimal high = new BigDecimal(priceParams.get("high").get(0));
        return productRepository.getProductsByPriceFilter(low, high);
    }

    @Override
    public
    List<Product> filterProducts(String category, Map<String, List<String>> priceParams, String manufacturer) {
        List<Product> productsByCategory = this.getProductsByCategory(category);
        List<Product> productsByPrice = new ArrayList<>(this.getProductsByPriceFilter(priceParams));
        List<Product> productsByManufacturer = this.getProductsByManufacturer(manufacturer);
        productsByCategory.retainAll(productsByPrice);
        productsByCategory.retainAll(productsByManufacturer);
        return productsByCategory;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}
