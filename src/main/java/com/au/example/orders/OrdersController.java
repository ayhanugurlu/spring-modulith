package com.au.example.orders;

import com.au.example.orders.model.Order;
import com.au.example.orders.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;


    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    void placeOrder(@RequestBody Order order) {
        orderService.place(order);
    }
}
