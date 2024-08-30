package com.au.example.orders.repository;

import com.au.example.orders.model.Order;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {
}
