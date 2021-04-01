package com.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Province implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;
    @NotBlank(message = "Trường này không được để trống")
    @Column(name = "nameProvince", nullable = false)
    private String name;

    @OneToMany(mappedBy = "province", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return "Province{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
