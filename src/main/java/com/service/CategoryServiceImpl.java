package com.service;

import com.model.Category;
import com.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements IBaseService<Category> {

    @Autowired
    CategoryRepository repository;

    @Override
    public Page<Category> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Category> findALl() {
        return repository.findAll();
    }

    @Override
    public Optional<Category> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(Category category) {
        repository.save(category);
    }

    @Override
    public void update(Category category) {
        repository.save(category);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Category> search(String title) {
        return repository.findByTitleContains(title);
    }

}
