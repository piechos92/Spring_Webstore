package com.piechos.webstore.domain.repository.impl;

import com.piechos.webstore.domain.Order;
import com.piechos.webstore.domain.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

    private Map<Long, Order> listOfOrders;
    private long nextOrderId;

    public InMemoryOrderRepository() {
        listOfOrders = new HashMap<>();
        nextOrderId = 1000;
    }

    @Override
    public Long saveOrder(Order order) {
        order.setOrderId(getNextOrderId());
        listOfOrders.put(order.getOrderId(), order);
        return order.getOrderId();
    }

    private synchronized long getNextOrderId() {
        return nextOrderId++;
    }
}
