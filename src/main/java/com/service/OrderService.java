package com.service;

import com.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService extends IBaseService<Order> {
    void delete(Long id);
    Page<Order> findByEmailContaining(String email, Pageable pageable);

    void saveCart(Order order, Order orderData);
}
