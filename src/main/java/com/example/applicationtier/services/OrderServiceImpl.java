package com.example.applicationtier.services;

import com.example.applicationtier.Contracts.OrderService;
import com.example.applicationtier.models.Order;
import com.example.applicationtier.networking.OrderClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderClient orderClient;

    public OrderServiceImpl() throws IOException {
        this.orderClient = new OrderClient();
    }

    @Override
    public ArrayList<Order> getAllOrders() {
        return orderClient.getAllOrders();
    }

    @Override
    public Order getOrderById(int id) throws IOException {
        return orderClient.getOrderById(id);
    }

    @Override
    public void addOrder(Order order) {
        orderClient.addOrder(order);
    }

    @Override
    public void deleteOrderByIdAsync(int id) {
        orderClient.deleteOrderByIdAsync(id);
    }

    @Override
    public void updateOrderAsync(Order order) {
        orderClient.updateOrderAsync(order);
    }
}
