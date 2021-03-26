package com.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String fullName;

    @NotEmpty
    @Column(nullable = false)
    private boolean role;

    @NotEmpty
    @Column(nullable = false)
    private String image;
    private String description;
    private String about;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @NotEmpty
    @Column(nullable = false)
    private String email;


}
