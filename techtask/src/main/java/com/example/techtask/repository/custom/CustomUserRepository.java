package com.example.techtask.repository.custom;

import com.example.techtask.model.User;

import java.util.List;

public interface CustomUserRepository {
    User findUserWithMaxTotalDeliveredIn2003();
    List<User> findUsersWithPaidOrdersIn2010();
}
