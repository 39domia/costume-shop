package com.service.impl;

import com.model.Order;
import com.model.OrderDetail;
import com.repository.OrderDetailRepository;
import com.repository.OrderRepository;
import com.service.OrderDetailService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Page<Order> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Order> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(Order order) {
        repository.save(order);
    }

    @Override
    public void update(Order order) {
        repository.save(order);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveCart(Order order, Order orderData) {
        order.setTotalPrice(orderData.getTotalPrice());
        order.setOrderDetails(orderData.getOrderDetails());
        repository.save(order);
        for (OrderDetail orderDetail1 : order.getOrderDetails()) {
            orderDetail1.setOrder(order);
        }
        orderDetailRepository.saveAll(order.getOrderDetails());
    }

    public Page<Order> findByEmailContaining(String email, Pageable pageable) {
        return repository.findByEmailContaining(email, pageable);
    }
}
