package com.piechos.webstore.service.impl;

import com.piechos.webstore.domain.Order;
import com.piechos.webstore.domain.Product;
import com.piechos.webstore.domain.repository.OrderRepository;
import com.piechos.webstore.domain.repository.ProductRepository;
import com.piechos.webstore.service.CartService;
import com.piechos.webstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartService cartService;


    @Override
    public void processOrder(String productId, int count) {
        Product productById = productRepository.getProductById(productId);
        if (productById.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Zbyt mało towaru. Obecna liczba sztuk w magazynie:" +
                    productById.getUnitsInStock());
        }
        productById.setUnitsInStock(productById.getUnitsInStock() - count);
    }

    @Override
    public Long saveOrder(Order order) {
        Long orderId = orderRepository.saveOrder(order);
        cartService.delete(order.getCart().getCartId());
        return orderId;
    }

}
