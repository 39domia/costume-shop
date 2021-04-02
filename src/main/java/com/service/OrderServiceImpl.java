package com.service;

import com.model.Category;
import com.model.Order;
import com.model.OrderDetail;
import com.repository.OrderRepository;
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

    @Override
    public Page<Order> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Order> findALl() {
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

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Order> findByEmailContaining(String email, Pageable pageable) {
        return repository.findByEmailContaining(email, pageable);
    }
}
