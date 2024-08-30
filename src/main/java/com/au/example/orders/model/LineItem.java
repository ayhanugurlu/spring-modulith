package com.au.example.orders.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders_line_items")
public record LineItem(@Id Integer id, int quantity, int product) {
}
