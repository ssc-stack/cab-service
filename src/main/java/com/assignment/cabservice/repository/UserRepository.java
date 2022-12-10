package com.assignment.cabservice.repository;

import com.assignment.cabservice.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Transactional
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
