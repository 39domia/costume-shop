package com.service;

import com.model.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements IBaseService<Product> {
    @Autowired
    ProductRepository repository;

    @Override
    public Page<Product> selectAll(Pageable pageable) {
        return repository.findAll(pageable);

    }

    @Override
    public List<Product> findALl() {
        return repository.findAll();

    }

    @Override
    public Optional<Product> findOne(Long id) {
        return repository.findById(id);

    }

    @Override
    public void add(Product product) {
        repository.save(product);

    }

    @Override
    public void update(Product product) {
        repository.save(product);

    }

    @Override
    public void delete(Long id) {

    }
}
