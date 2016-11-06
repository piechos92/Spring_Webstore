package com.piechos.webstore.validator;


import com.piechos.webstore.domain.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductImageValidator implements Validator {

    private long allowedSize;

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        if(product.getProductImage().getSize() > allowedSize) {
            errors.rejectValue("productImage", "com.piechos.webstore.validator.ProductImageValidator.message");
        }
    }

    public void setAllowedSize(long allowedSize) {
        this.allowedSize = allowedSize;
    }
}
