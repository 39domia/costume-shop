package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false, length = 1000)
    private String nameProduct;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long rating;

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false, length = 2000)
    private String shortDescription;

    @Lob
    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String description;

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false, length = 2000)
    private String image;
    private String status;
    private String size;
    private String color;
    private String length;
    private String fabric; //chất liệu vải
    private String warranty;
//    @Where(clause = "deleted = false")
    private boolean deleted = false;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetail;


    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")      //category - product (n - 1) ok
    private Category category;

    @ManyToMany(mappedBy = "productListTag", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)        //ok
    private List<Tag> tags = new ArrayList<>();

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", shortDescription='" + shortDescription + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", length='" + length + '\'' +
                ", fabric='" + fabric + '\'' +
                ", warranty='" + warranty + '\'' +
                '}';
    }
}
