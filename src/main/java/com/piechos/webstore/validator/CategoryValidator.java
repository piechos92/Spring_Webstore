package com.piechos.webstore.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class CategoryValidator implements ConstraintValidator<Category, String> {

    private List<String> allowedCategories;

    public CategoryValidator() {
        allowedCategories = new ArrayList<>();
        allowedCategories.add("Smart Phone");
        allowedCategories.add("Laptop");
        allowedCategories.add("Tablet");
    }

    @Override
    public void initialize(Category category) {
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(allowedCategories.contains(s)) {
            return true;
        } else {
            return false;
        }
    }
}
