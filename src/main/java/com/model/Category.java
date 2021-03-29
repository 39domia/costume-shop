package com.model;

import com.validation.CategoryValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class Category extends CategoryValidator implements Serializable, Validator {
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


}
