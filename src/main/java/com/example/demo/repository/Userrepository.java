package com.example.demo.repository;

import com.example.demo.entity.UserSEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository
        extends JpaRepository<UserSEntity, Long> {

    boolean existsByEmail(String email);

    UserSEntity findByEmail(String email);
}
