package com.model;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer implements Serializable, Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Column(nullable = false)
    private String firstName;
    @NotEmpty
    @Column(nullable = false)
    private String lastName;
    private String companyName;//
    @NotEmpty
    @Column(nullable = false)
    private String address1;
    private String address2;//
    @NotEmpty
    @Column(nullable = false)
    private String city;
    @NotEmpty
    @Column(nullable = false)
    private String email;
    @NotEmpty
    @Column(nullable = false)
    private String phone;
    private String note;//


    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER) //product - category (1 - n)
    private List<Order> orders = new ArrayList<>();

    //validation
    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        String nameCustomer = customer.getFirstName();
        ValidationUtils.rejectIfEmpty(errors, "firstName", "name.empty");
        if (nameCustomer.length() > 250 || nameCustomer.length() < 2) {
            errors.rejectValue("firstName", "name.length");
        }
    }


}
