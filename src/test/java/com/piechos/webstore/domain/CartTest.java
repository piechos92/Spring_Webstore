package com.piechos.webstore.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {

    private Cart cart;

    @Before
    public void setup() {
        cart = new Cart();
    }

    @Test
    public void check_get_grand_total_method() {
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        Product tablet = new Product("P1235", "Tablet", new BigDecimal(300));
        CartItem cartItem1 = new CartItem(iphone);
        CartItem cartItem2 = new CartItem(tablet);
        cart.addCartItem(cartItem1);
        cart.addCartItem(cartItem2);
        Assert.assertEquals(cartItem1.getTotalPrice().add(cartItem2.getTotalPrice()), cart.getGrandTotal());
    }
}
