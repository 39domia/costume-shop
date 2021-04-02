package com.repository;

import com.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByEmailAndDeleteIsFalseContaining(String email, Pageable pageable);

    List<Order> findAllByDeleteIsFalse();
    Page<Order> findAllByDeleteIsFalse(Pageable pageable);

}
