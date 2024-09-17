package com.example.techtask.repository;

import com.example.techtask.model.User;
import com.example.techtask.repository.custom.CustomUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, CustomUserRepository {
}
