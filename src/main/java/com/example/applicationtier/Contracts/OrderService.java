package com.example.applicationtier.Contracts;

import com.example.applicationtier.entities.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    List<Order> getOrders() throws IOException;
    List<Order> getOrdersFromUser(int userID) throws IOException;
    Order getOrderById(int id) throws IOException;
    void addOrder(Order order);
    void deleteOrderByIdAsync(int id);
    void updateOrderAsync(Order order);
}
