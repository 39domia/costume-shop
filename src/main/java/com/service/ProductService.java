package com.service;

import com.model.Category;
import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService extends IBaseService<Product>{
    Page<Product> findByNameProductContaining(String nameProduct, Pageable pageable);

    List<Product> findTop4ByOrderByIdDesc();

    List<Product> findTop3ByOrderByIdDesc();

    List<Product> findTop4ByOrderByRatingDesc();

    List<Product> findTop5ByOrderByIdDesc();

    Page<Product> findByNameProductAndIsDeleteContaining(String nameProduct, Pageable pageable); // note check

    List<Product> findTop4ByIsDeleteIsFalseOrderByIdDesc();

    List<Product> findTop3ByIsDeleteIsFalseOrderByIdDesc();

    List<Product> findTop5ByIsDeleteIsFalseOrderByIdDesc();

    List<Product> findTop4ByIsDeleteIsFalseOrderByRatingDesc();

    List<Product> findTop4ByDeletedIsFalseOrderByPriceAsc();


    List<Product> findAllByCategoryAndIsDeleteIsFalse(Category category);

    Page<Product> findAllByCategoryAndIdIsDeleteIsFalse(Long category_id, Pageable pageable);

    void deleteTrue(Long id);

    void softDelete(Long id);

    Page<Product> findByNameProductAndDeletedIsFalseContaining(String nameProduct, Pageable pageable); // note check

    List<Product> findTop4ByDeletedIsTrueOrderByIdDesc();

    List<Product> findTop3ByDeletedIsTrueOrderByIdDesc();

    List<Product> findTop5ByDeletedIsTrueOrderByIdDesc();

    List<Product> findTop4ByDeletedIsTrueOrderByRatingDesc();

    List<Product> findAllByCategoryAndDeletedIsTrue(Category category);

    Page<Product> findAllByCategoryAndIdDeletedIsTrue(Long category_id, Pageable pageable);

    Optional<Product> findByIdAndDeletedIsTrue(Long id);

    Page<Product> findAllByDeletedIsTrue(Pageable pageable);

    Page<Product> findByDeletedIsTrueAndNameProductContaining(String nameProduct, Pageable pageable); // note check



}
