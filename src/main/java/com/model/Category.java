package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category implements Serializable, Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NotEmpty
    @Column(name = "nameCategory", nullable = false)
    private String name;
    private String description;
    private String image;


    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER) //product - category (1 - n)
    private List<Product> products = new ArrayList<>();

    //validation
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
