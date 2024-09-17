package com.example.techtask.repository.custom.impl;

import com.example.techtask.model.User;
import com.example.techtask.repository.custom.CustomUserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findUserWithMaxTotalDeliveredIn2003() {
        String hql = "SELECT u FROM User u " +
                "JOIN Order o ON u.id = o.userId " +
                "WHERE EXTRACT(YEAR FROM o.createdAt) = 2003 " +
                "AND o.orderStatus = 'DELIVERED' " +
                "GROUP BY u.id " +
                "ORDER BY SUM(o.price * o.quantity) DESC";

        return entityManager.createQuery(hql, User.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public List<User> findUsersWithPaidOrdersIn2010() {
        String hql = "SELECT DISTINCT u FROM User u " +
                "JOIN Order o ON u.id = o.userId " +
                "WHERE EXTRACT(YEAR FROM o.createdAt) = 2010 " +
                "AND o.orderStatus = 'PAID'";

        return entityManager.createQuery(hql, User.class).getResultList();
    }
}
