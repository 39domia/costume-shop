package com.validation;

import com.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CategoryValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Category category = (Category) target;
        String nameCate = category.getName();
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        if (nameCate.length() > 250 || nameCate.length() < 2) {
            errors.rejectValue("name", "name.length");
        }
    }
}

