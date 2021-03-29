package com.repository;

import com.model.Category;
import com.model.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Page<Tag> findByNameContaining(String name, Pageable pageable);

}
