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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable, Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NotEmpty
    @Column(nullable = false)
    private String nameProduct;
//    @NotEmpty
    @Column(nullable = false)
    private Long price;
//    @NotEmpty
    @Column(nullable = false)
    private Long rating;
    @NotEmpty
    @Column(nullable = false)
    private String description;
    @NotEmpty
    @Column(nullable = false)
    private String image;
    private String status;
    private String size;
    private String color;
    private String length;
    private String fabric;
    private String warranty;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")      //category - product (n - 1) ok
    private Category category;

    @ManyToMany(mappedBy = "productListTag", fetch = FetchType.EAGER)        //ok
    private List<Tag> tags = new ArrayList<>();

    //validation
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        String nameProduct = product.getNameProduct();
        ValidationUtils.rejectIfEmpty(errors, "nameProduct", "name.empty");
        if (nameProduct.length() > 250 || nameProduct.length() < 2) {
            errors.rejectValue("nameProduct", "name.length");
        }
    }


}
