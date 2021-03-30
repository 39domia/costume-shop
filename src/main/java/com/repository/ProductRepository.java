package com.repository;

import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameProductContaining(String nameProduct, Pageable pageable);

    List<Product> findTop4ByOrderByIdDesc();

    List<Product> findTop4ByOrderByRatingDesc();

}
