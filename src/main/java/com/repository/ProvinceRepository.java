package com.repository;

import com.model.Category;
import com.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Page<Province> findByNameContaining(String title, Pageable pageable);

}
