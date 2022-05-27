package com.example.applicationtier.models;

import com.example.applicationtier.entities.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OrderModel {
    public List<Order> getOrders();
    public Order getOrderById(int id) throws IOException;
    public void addOrder(Order order);
    public void deleteOrderByIdAsync(int id);
    public void updateOrderAsync(Order order);
}
