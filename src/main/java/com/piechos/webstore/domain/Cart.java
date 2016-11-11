package com.piechos.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {

    private static final long serialVersionUID = -3948735680343733305L;
    private String cartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    public Cart() {
        cartItems = new HashMap<>();
        grandTotal = new BigDecimal(0);
    }

    public Cart(String cartId) {
        this();
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void addCartItem(CartItem cartItem) {
        String productId = cartItem.getProduct().getProductId();
        if(cartItems.containsKey(productId)) {
            CartItem existingCarItem = cartItems.get(productId);
            existingCarItem.setQuantity(existingCarItem.getQuantity() + cartItem.getQuantity());
            existingCarItem.updateTotalPrice();
            cartItems.put(productId, existingCarItem);
        } else {
            cartItems.put(productId, cartItem);
        }
        updateGrandTotal();
    }

    public void removeCarItem(CartItem cartItem) {
        String productId = cartItem.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }

    public void updateGrandTotal() {
        grandTotal = new BigDecimal(0);
        for (CartItem cartItem : cartItems.values()) {
            grandTotal = grandTotal.add(cartItem.getTotalPrice());
        }
    }

    @Override
    public int hashCode() {
        final int prime = 71;
        int result = 1;
        result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        Cart other = (Cart) object;
        if (cartId == null) {
            if (other.cartId != null) {
                return false;
            }
        } else if (!cartId.equals(other.cartId)) {
            return false;
        }
        return true;
    }

}
