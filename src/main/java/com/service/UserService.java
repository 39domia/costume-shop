package com.service;

import com.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService extends IBaseService<User>{
    Page<User> findByFullNameContaining(String name, Pageable pageable);
    void delete(Long id);
}
