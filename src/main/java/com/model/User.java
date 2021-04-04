package com.model;

import lombok.Data;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Trường này không được để trống")
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String role;

    @Transient
    private CommonsMultipartFile[] image;

    private String imageUrl;

    @Column(length = 5000)
    private String description;
    @Column(length = 5000)
    private String about;





}
