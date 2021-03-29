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
    @Column(nullable = false)
    private Date date;
    @NotEmpty
    @Column(nullable = false)
    private String paymentMethod;


    @Column(nullable = false)
    private Long status;

    //customer

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

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();





//    validation

    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);
    }



    public void validate(Object target, Errors errors) {
        Order tag = (Order) target;
        String nameTag = tag.getAddress1();
        ValidationUtils.rejectIfEmpty(errors, "address1", "name.empty");
        if (nameTag.length() > 250 || nameTag.length() < 2) {
            errors.rejectValue("name", "name.length");
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status=" + status +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
