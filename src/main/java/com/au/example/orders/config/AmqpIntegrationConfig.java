package com.au.example.orders.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpIntegrationConfig {

    public static final String ORDER_QUEUE = "orders";

    @Bean
    Binding binding(Queue orders, Exchange exchange){
        return BindingBuilder.bind(orders).to(exchange).with(ORDER_QUEUE).noargs();
    }


    @Bean
    Queue orders(){
        return QueueBuilder.durable(ORDER_QUEUE).build();
    }
    @Bean
    Exchange exchange(){
        return ExchangeBuilder.directExchange(ORDER_QUEUE).durable(true).build();
    }

}
