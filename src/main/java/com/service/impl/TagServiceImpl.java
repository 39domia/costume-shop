package com.service.impl;

import com.model.Category;
import com.model.Tag;
import com.repository.TagRepository;
import com.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository repository;

    @Override
    public Page<Tag> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Tag> findAll() {
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


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<Tag> findByNameContaining(String name, Pageable pageable) {
        return repository.findByNameContaining(name, pageable);
    }
}
