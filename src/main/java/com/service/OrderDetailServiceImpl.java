package com.service;

import com.model.OrderDetail;
import com.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements IBaseService<OrderDetail> {

    @Autowired
    OrderDetailRepository repository;

    @Override
    public Page<OrderDetail> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<OrderDetail> findALl() {
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

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
