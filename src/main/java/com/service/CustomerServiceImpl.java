package com.service;

import com.model.Customer;
import com.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements IBaseService<Customer> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Page<Customer> selectAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> findALl() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> findOne(Long id) {
        return repository.findById(id);
    }

    @Override
    public void add(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
