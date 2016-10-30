package com.piechos.webstore.service;


public interface OrderService {

    void processOrder(String productId, int count);
}
