package com.au.example.orders.event;

import com.au.example.orders.config.AmqpIntegrationConfig;
import org.springframework.modulith.events.Externalized;

@Externalized(target = AmqpIntegrationConfig.ORDER_QUEUE)
public record OrderPlacedExternalEvent(int orderId) {
}
