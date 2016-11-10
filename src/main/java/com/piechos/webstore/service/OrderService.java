package com.piechos.webstore.service;

import com.piechos.webstore.domain.Order;

public interface OrderService {

    void processOrder(String productId, int count);
    Long saveOrder(Order order);
}
