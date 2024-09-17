package com.example.techtask.service.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements com.example.techtask.service.UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUser() {
        return userRepository.findUserWithMaxTotalDeliveredIn2003();
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findUsersWithPaidOrdersIn2010();
    }
}
