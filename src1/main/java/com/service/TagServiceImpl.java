package com.service;

import com.model.Tag;
import com.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements IBaseService<Tag> {

    @Autowired
    TagRepository repository;

    @Override
    public Page<Tag> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Tag> findALl() {
        return repository.findAll();
    }

    @Override
    public Optional<Tag> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(Tag tag) {
        repository.save(tag);
    }

    @Override
    public void update(Tag tag) {
        repository.save(tag);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
