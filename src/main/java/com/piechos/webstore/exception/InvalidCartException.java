package com.piechos.webstore.exception;

public class InvalidCartException extends RuntimeException {

    private static final long serialVersionUID = 1071371981256057595L;
    private String cartId;

    public InvalidCartException(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }

}
