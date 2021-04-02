package com.service;

import com.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends IBaseService<Category> {
    Page<Category> findByNameContaining(String name, Pageable pageable);

    void delete(Long id);
}
