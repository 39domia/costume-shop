package com.service;

import com.model.Category;
import com.model.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        repository.deleteById(id);
    }

    public Page<Product> findByNameProductContaining(String nameProduct, Pageable pageable) {
        return repository.findByNameProductContaining(nameProduct, pageable);
    }

    public List<Product> findTop4ByOrderByIdDesc() {
        return repository.findTop4ByOrderByIdDesc();
    }

    public List<Product> findTop3ByOrderByIdDesc() {
        return repository.findTop3ByOrderByIdDesc();
    }

    public List<Product> findTop4ByOrderByRatingDesc() {
        return repository.findTop4ByOrderByRatingDesc();
    }

    public List<Product> findTop5ByOrderByIdDesc() {
        return repository.findTop5ByOrderByIdDesc();
    }


}
