package com.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String nameProduct;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long rating;
    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String shortDescription;
    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String description;
    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String image;
    private String status;
    private String size;
    private String color;
    private String length;
    private String fabric; //chất liệu vải
    private String warranty;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")      //category - product (n - 1) ok
    private Category category;

    @ManyToMany(mappedBy = "productListTag", fetch = FetchType.EAGER)        //ok
    private List<Tag> tags = new ArrayList<>();


}
