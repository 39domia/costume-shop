package com.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @NotEmpty
    @Column(name = "nameProvince", nullable = false)
    private String name;

    @OneToMany(mappedBy = "province", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();




}
