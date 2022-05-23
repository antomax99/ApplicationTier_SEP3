package com.example.applicationtier.models;

import java.io.IOException;
import java.util.ArrayList;

public interface OrderModel {
    public ArrayList<Order> getAllOrders();
    public Order getOrderById(int id) throws IOException;
    public void addOrder(Order order);
    public void deleteOrderByIdAsync(int id);
    public void updateOrderAsync(Order order);
}
