package com.piechos.webstore.domain.repository;

import com.piechos.webstore.domain.Product;
import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    Product getProductById(String productId);
}
