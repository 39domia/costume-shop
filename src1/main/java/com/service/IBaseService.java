package com.service;


import com.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IBaseService<T> {
    Page<T> selectAll(Pageable pageable);

    List<T> findALl();

    Optional<T> findOne(Long id);

    void add(T t);

    void update(T t);

    void delete(Long id);



}
