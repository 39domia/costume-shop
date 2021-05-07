package com.service;

import com.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService extends IBaseService<Tag>{
    void delete(Long id);
    Page<Tag> findByNameContaining(String name, Pageable pageable);
}
