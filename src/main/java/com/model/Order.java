package com.model;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NotEmpty
    @Column(nullable = false)
    private Date date;
    @NotEmpty
    @Column(nullable = false)
    private String paymentMethod;

    @NotEmpty
    @Column(nullable = false)
    private Long status;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")      //category - product (n - 1)
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")      //category - product (n - 1)
    private Customer customer;


    //validation
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Order.class.isAssignableFrom(clazz);
//    }
//
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Order tag = (Order) target;
//        String nameTag = tag.getName();
//        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
//        if (nameTag.length() > 250 || nameTag.length() < 2) {
//            errors.rejectValue("name", "name.length");
//        }
//    }
}
