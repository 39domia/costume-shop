package com.service.impl;

import com.model.Category;
import com.model.OrderDetail;
import com.model.Product;
import com.repository.OrderDetailRepository;
import com.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository repository;

    @Override
    public Page<OrderDetail> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<OrderDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<OrderDetail> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(OrderDetail orderDetail) {
        repository.save(orderDetail);
    }

    @Override
    public void update(OrderDetail orderDetail) {
        repository.save(orderDetail);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }


}