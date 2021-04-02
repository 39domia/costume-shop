package com.repository;

import com.model.Category;
import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameProductContaining(String nameProduct, Pageable pageable);

    List<Product> findTop4ByOrderByIdDesc();

    List<Product> findTop3ByOrderByIdDesc();

    List<Product> findTop5ByOrderByIdDesc();

    List<Product> findTop4ByOrderByRatingDesc();

    List<Product> findAllByCategory(Category category);

    Page<Product> findAllByCategoryId(Long category_id, Pageable pageable);

    Page<Product> findByNameProductAndIsDeleteContaining(String nameProduct, Pageable pageable); // note check

    List<Product> findTop4ByIsDeleteIsFalseOrderByIdDesc();

    List<Product> findTop3ByIsDeleteIsFalseOrderByIdDesc();

    List<Product> findTop5ByIsDeleteIsFalseOrderByIdDesc();

    List<Product> findTop4ByIsDeleteIsFalseOrderByRatingDesc();

    List<Product> findAllByCategoryAndIsDeleteIsFalse(Category category);

    Page<Product> findAllByCategoryAndIdIsDeleteIsFalse(Long category_id, Pageable pageable);

    List<Product> findAllByIsDeleteIsFalse();

    Page<Product> findAllByIsDeleteIsFalse(Pageable pageable);

    Optional<Product> findByIdAndIsDeleteIsFalse(Long id);
}
