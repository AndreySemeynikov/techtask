package com.example.techtask.repository;

import com.example.techtask.model.Order;
import com.example.techtask.repository.custom.CustomOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer>, CustomOrderRepository {
}
