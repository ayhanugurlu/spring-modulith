package com.au.example.orders.service;

import com.au.example.orders.event.OrderPlacedExternalEvent;
import com.au.example.orders.model.Order;
import com.au.example.orders.repository.OrderRepository;
import com.au.example.orders.event.OrderPlacedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final ApplicationEventPublisher applicationEventPublisher;



    public OrderService(OrderRepository orderRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.orderRepository = orderRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void place(Order order) {
        var saved = orderRepository.save(order);
        System.out.println("Order placed: " + saved);

        this.applicationEventPublisher.publishEvent(new OrderPlacedEvent(saved.id()));
        this.applicationEventPublisher.publishEvent(new OrderPlacedExternalEvent(saved.id()));
    }
}
