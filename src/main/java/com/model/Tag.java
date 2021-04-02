package com.model;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_tags",
            joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> productListTag = new ArrayList<>();


    //validation
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Tag.class.isAssignableFrom(clazz);
//    }
//
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Tag tag = (Tag) target;
//        String nameTag = tag.getName();
//        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
//        if (nameTag.length() > 250 || nameTag.length() < 2) {
//            errors.rejectValue("name", "name.length");
//        }
//    }


    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

