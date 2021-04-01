package com.repository;

import com.model.Category;
import com.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findByFullNameContaining(String fullName, Pageable pageable);

    User findByEmail(String email);

}
