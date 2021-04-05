package com.service.impl;

import com.model.Category;
import com.model.Product;
import com.repository.ProductRepository;
import com.service.ProductService;
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
        return repository.findAllByDeletedIsFalse(pageable);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAllByDeletedIsFalse();
    }

    @Override
    public Optional<Product> findOne(Long id) {
        return repository.findByIdAndDeletedIsFalse(id);

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
        found.setDeleted(true);
    }

    @Override
    public Page<Product> findByNameProductAndDeletedIsFalseContaining(String nameProduct, Pageable pageable) {
        return null;
    }

    @Override
    public List<Product> findTop4ByDeletedIsTrueOrderByIdDesc() {
        return null;
    }

    @Override
    public List<Product> findTop3ByDeletedIsTrueOrderByIdDesc() {
        return null;
    }

    @Override
    public List<Product> findTop5ByDeletedIsTrueOrderByIdDesc() {
        return null;
    }

    @Override
    public List<Product> findTop4ByDeletedIsTrueOrderByRatingDesc() {
        return null;
    }

    @Override
    public List<Product> findAllByCategoryAndDeletedIsTrue(Category category) {
        return null;
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
        return repository.findByDeletedIsFalseAndNameProductContaining(nameProduct, pageable);
    }

    @Override
    public List<Product> findTop4ByIsDeleteIsFalseOrderByIdDesc() {
        return repository.findTop4ByDeletedIsFalseOrderByIdDesc();
    }

    @Override
    public List<Product> findTop3ByIsDeleteIsFalseOrderByIdDesc() {
        return repository.findTop3ByDeletedIsFalseOrderByIdDesc();
    }

    @Override
    public List<Product> findTop5ByIsDeleteIsFalseOrderByIdDesc() {
        return repository.findTop5ByDeletedIsFalseOrderByIdDesc();
    }

    @Override
    public List<Product> findTop4ByIsDeleteIsFalseOrderByRatingDesc() {
        return repository.findTop4ByDeletedIsFalseOrderByRatingDesc();
    }

    @Override
    public List<Product> findTop4ByDeletedIsFalseOrderByPriceAsc() {
        return repository.findTop4ByDeletedIsFalseOrderByPriceAsc();
    }

    @Override
    public List<Product> findAllByCategoryAndIsDeleteIsFalse(Category category) {
        return repository.findAllByCategoryAndDeletedIsFalse(category);
    }

    @Override
    public Page<Product> findAllByCategoryAndIdIsDeleteIsFalse(Long category_id, Pageable pageable) {
        return repository.findAllByCategoryIdAndDeletedIsFalse(category_id, pageable);
    }

    @Override
    public Page<Product> findAllByCategoryAndIdDeletedIsTrue(Long category_id, Pageable pageable) {
        return repository.findAllByCategoryIdAndDeletedIsTrue(category_id, pageable);
    }

    @Override
    public Optional<Product> findByIdAndDeletedIsTrue(Long id) {
        return repository.findByIdAndDeletedIsTrue(id);
    }

    @Override
    public Page<Product> findAllByDeletedIsTrue(Pageable pageable) {
        return repository.findAllByDeletedIsTrue(pageable);
    }

    @Override
    public Page<Product> findByDeletedIsTrueAndNameProductContaining(String nameProduct, Pageable pageable) {
        return repository.findByDeletedIsTrueAndNameProductContaining(nameProduct, pageable);
    }
}
