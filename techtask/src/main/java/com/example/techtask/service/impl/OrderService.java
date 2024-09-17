package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderService implements com.example.techtask.service.OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order findOrder() {
        return orderRepository.findNewestOrderWithMoreThanOneItem();
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findOrdersByActiveUsersSortedByCreationDate();
    }
}
