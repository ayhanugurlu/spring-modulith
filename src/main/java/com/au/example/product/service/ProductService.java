package com.au.example.product.service;


import com.au.example.orders.event.OrderPlacedEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @ApplicationModuleListener
    void onOrderPlacedEvent(OrderPlacedEvent orderPlacedEvent){
        System.out.println("Product service received order placed event: " + orderPlacedEvent);
    }

}
