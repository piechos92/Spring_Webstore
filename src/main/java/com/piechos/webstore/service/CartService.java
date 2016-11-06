package com.piechos.webstore.service;

import com.piechos.webstore.domain.Cart;

public interface CartService {

    Cart create(Cart cart);
    Cart read(String cartId);
    void update(String cartId, Cart cart);
    void delete(String cartId);

}
