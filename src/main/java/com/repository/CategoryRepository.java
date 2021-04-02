package com.repository;

import com.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Page<Category> findByNameAndIsDeleteIsFalseContaining(String name, Pageable pageable);

    Category findByNameAndIsDeleteIsFalse(String name);
}
