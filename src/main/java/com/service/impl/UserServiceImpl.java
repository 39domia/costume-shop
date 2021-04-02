package com.service.impl;


import com.model.Category;
import com.model.User;
import com.repository.UserRepository;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public Page<User> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(User user) {
        repository.save(user);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<User> findByFullNameContaining(String name, Pageable pageable) {
        return repository.findByFullNameContaining(name, pageable);
    }
}
