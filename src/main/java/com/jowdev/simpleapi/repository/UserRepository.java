package com.jowdev.simpleapi.repository;

import com.jowdev.simpleapi.model.Message;
import com.jowdev.simpleapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
}

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}