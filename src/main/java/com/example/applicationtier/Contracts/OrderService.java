package com.example.applicationtier.Contracts;

import com.example.applicationtier.entities.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    public List<Order> getOrders() throws IOException;
    public Order getOrderById(int id) throws IOException;
    public void addOrder(Order order);
    public void deleteOrderByIdAsync(int id);
    public void updateOrderAsync(Order order);
}
