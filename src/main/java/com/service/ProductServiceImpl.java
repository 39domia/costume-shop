package com.service;

import com.model.Category;
import com.model.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Override
    public Page<Product> selectAll(Pageable pageable) {
        return repository.findAllByIsDeleteIsFalse(pageable);
    }

    @Override
    public List<Product> findALl() {
        return repository.findAllByIsDeleteIsFalse();
    }

    @Override
    public Optional<Product> findOne(Long id) {
        return repository.findByIdAndIsDeleteIsFalse(id);

    }

    @Override
    public void add(Product product) {
        repository.save(product);

    }

    @Override
    public void update(Product product) {
        repository.save(product);
    }


    public void deleteTrue(Long id) {
        //repository.deleteById(id);
        Product found = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        repository.delete(found);
    }

    public void softDelete(Long id) {
        Product found = repository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        found.setDelete(true);
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

    @Override
    public Page<Product> findByNameProductAndIsDeleteContaining(String nameProduct, Pageable pageable) {
        return repository.findByNameProductAndIsDeleteContaining(nameProduct, pageable);
    }

    @Override
    public List<Product> findTop4ByIsDeleteIsFalseOrderByIdDesc() {
        return repository.findTop4ByIsDeleteIsFalseOrderByIdDesc();
    }

    @Override
    public List<Product> findTop3ByIsDeleteIsFalseOrderByIdDesc() {
        return repository.findTop3ByIsDeleteIsFalseOrderByIdDesc();
    }

    @Override
    public List<Product> findTop5ByIsDeleteIsFalseOrderByIdDesc() {
        return repository.findTop5ByIsDeleteIsFalseOrderByIdDesc();
    }

    @Override
    public List<Product> findTop4ByIsDeleteIsFalseOrderByRatingDesc() {
        return repository.findTop4ByIsDeleteIsFalseOrderByRatingDesc();
    }

    @Override
    public List<Product> findAllByCategoryAndIsDeleteIsFalse(Category category) {
        return repository.findAllByCategoryAndIsDeleteIsFalse(category);
    }

    @Override
    public Page<Product> findAllByCategoryAndIdIsDeleteIsFalse(Long category_id, Pageable pageable) {
        return repository.findAllByCategoryAndIdIsDeleteIsFalse(category_id, pageable);
    }
}
