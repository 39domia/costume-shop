package com.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @NotEmpty
    @Column(nullable = false)
    private String nameProduct;
    @NotEmpty
    @Column(nullable = false)
    private Long price;
    @NotEmpty
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

}
