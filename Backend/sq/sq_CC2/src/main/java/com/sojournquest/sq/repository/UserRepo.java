package com.sojournquest.sq.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sojournquest.sq.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    User findByFullnameAndPassword(String username, String password);

    User findByEmail(String email);

    void deleteByEmail(String userEmail);

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
