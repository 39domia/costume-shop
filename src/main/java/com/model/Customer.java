package com.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer implements Serializable {
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




}
