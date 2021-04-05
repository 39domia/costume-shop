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

    Page<Product> findByDeletedIsFalseAndNameProductContaining(String nameProduct, Pageable pageable); // note check

    List<Product> findTop4ByDeletedIsFalseOrderByIdDesc();

    List<Product> findTop4ByDeletedIsFalseOrderByPriceAsc();


    List<Product> findTop3ByDeletedIsFalseOrderByIdDesc();

    List<Product> findTop5ByDeletedIsFalseOrderByIdDesc();

    List<Product> findTop4ByDeletedIsFalseOrderByRatingDesc();

    // soft delete: false

    List<Product> findAllByCategoryAndDeletedIsFalse(Category category);

    Page<Product> findAllByCategoryIdAndDeletedIsFalse(Long categoryId, Pageable pageable);

    List<Product> findAllByDeletedIsFalse();

    Page<Product> findAllByDeletedIsFalse(Pageable pageable);

    Optional<Product> findByIdAndDeletedIsFalse(Long id);

//    Page<Product> findByNameProductAndDeletedIsFalseContaining(String nameProduct, Pageable pageable);

    // soft delete: true

    List<Product> findTop4ByDeletedIsTrueOrderByIdDesc();

    List<Product> findTop3ByDeletedIsTrueOrderByIdDesc();

    List<Product> findTop5ByDeletedIsTrueOrderByIdDesc();

    List<Product> findTop4ByDeletedIsTrueOrderByRatingDesc();

    List<Product> findAllByCategoryIdAndDeletedIsTrue(Long categoryId);

    Page<Product> findAllByCategoryIdAndDeletedIsTrue(Long categoryId, Pageable pageable);

    Optional<Product> findByIdAndDeletedIsTrue(Long id);

    Page<Product> findAllByDeletedIsTrue(Pageable pageable);

    Page<Product> findByDeletedIsTrueAndNameProductContaining(String nameProduct, Pageable pageable); // note check


}
