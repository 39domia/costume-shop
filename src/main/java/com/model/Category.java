package com.model;

import com.validation.CategoryValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Trường này không được để trống")
    @Size( max = 250, message = "Độ dài tối đa [1 - 250]")
    @Column(name = "nameCategory", nullable = false)
    private String name;
    @NotBlank(message = "Trường này không được để trống")
    private String description;
    private String image;
//    @Where(clause = "delete = false")
//    private boolean isDelete =false;
    

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER) //product - category (1 - n)
    private List<Product> products = new ArrayList<>();


    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
