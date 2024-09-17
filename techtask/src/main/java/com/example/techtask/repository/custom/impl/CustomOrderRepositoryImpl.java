package com.example.techtask.repository.custom.impl;

import com.example.techtask.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomOrderRepositoryImpl implements com.example.techtask.repository.custom.CustomOrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Order> findOrdersByActiveUsersSortedByCreationDate() {
        String hql = "SELECT o FROM Order o " +
                "JOIN User u ON u.id = o.userId " +
                "WHERE u.userStatus = 'ACTIVE' " +
                "ORDER BY o.createdAt DESC";

        return entityManager.createQuery(hql, Order.class).getResultList();
    }

    @Override
    public Order findNewestOrderWithMoreThanOneItem() {
        String hql = "SELECT o FROM Order o " +
                "WHERE o.quantity > 1 " +
                "ORDER BY o.createdAt DESC";

        return entityManager.createQuery(hql, Order.class)
                .setMaxResults(1)
                .getSingleResult();
    }
}
