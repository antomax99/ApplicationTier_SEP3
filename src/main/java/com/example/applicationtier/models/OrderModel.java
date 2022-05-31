package com.example.applicationtier.models;

import com.example.applicationtier.entities.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OrderModel {
     List<Order> getOrders();
     List<Order> getOrdersFromUser(int userID);
     Order getOrderById(int id) throws IOException;
     void addOrder(Order order);
     void deleteOrderByIdAsync(int id);
     void updateOrderAsync(Order order);
}
