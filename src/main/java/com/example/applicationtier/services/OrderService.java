package com.example.applicationtier.services;

import com.example.applicationtier.models.Order;

import java.io.IOException;
import java.util.ArrayList;

public interface OrderService {
    public ArrayList<Order> getAllOrders();
    public Order getOrderById(int id) throws IOException;
    public void addOrder(Order order);
    public void deleteOrderByIdAsync(int id);
    public void updateOrderAsync(Order order);
}
