package com.service;

import com.model.Category;
import com.model.Province;
import com.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvinceServiceImpl implements IBaseService<Province> {

    @Autowired
    ProvinceRepository repository;

    @Override
    public Page<Province> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Province> findALl() {
        return repository.findAll();
    }

    @Override
    public Optional<Province> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(Province category) {
        repository.save(category);
    }

    @Override
    public void update(Province category) {
        repository.save(category);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

//    public Page<Province> findByNameContaining(String title, Pageable pageable) {
//        return repository.findByNameContaining(title, pageable);
//    }
}
