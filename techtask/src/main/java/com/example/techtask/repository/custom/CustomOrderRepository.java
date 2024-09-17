package com.example.techtask.repository.custom;

import com.example.techtask.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomOrderRepository {
    List<Order> findOrdersByActiveUsersSortedByCreationDate();
    Order findNewestOrderWithMoreThanOneItem();
}
