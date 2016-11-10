package com.piechos.webstore.domain.repository;

import com.piechos.webstore.domain.Order;

public interface OrderRepository {

    Long saveOrder(Order order);

}
