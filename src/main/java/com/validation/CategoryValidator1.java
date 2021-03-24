package com.validation;

import com.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CategoryValidator1 implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return Category.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        Category category = (Category) target;
        if (category.getName().length() < 0) {
            errors.rejectValue("name", "negativevalue");
        } else if (category.getName().length() > 110) {
            errors.rejectValue("name", "too.darn.old");
        }
    }
}
// thang vu to

//ăttawtwatawtawtwa