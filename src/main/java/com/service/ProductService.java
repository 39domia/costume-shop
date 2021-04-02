package com.service;

import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService extends IBaseService<Product>{
    Page<Product> findByNameProductContaining(String nameProduct, Pageable pageable);

    List<Product> findTop4ByOrderByIdDesc();

    List<Product> findTop3ByOrderByIdDesc();

    List<Product> findTop4ByOrderByRatingDesc();

    List<Product> findTop5ByOrderByIdDesc();
}
