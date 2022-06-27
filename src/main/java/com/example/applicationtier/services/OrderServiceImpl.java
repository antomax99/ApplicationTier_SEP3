package com.example.applicationtier.services;

import com.example.applicationtier.Contracts.OrderService;
import com.example.applicationtier.entities.Order;
import com.example.applicationtier.entities.Product;
import com.example.applicationtier.networking.OrderClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderClient orderClient;

    public OrderServiceImpl() throws IOException {
        this.orderClient = new OrderClient();
    }

    @Override
    public List<Order> getOrders()  {
        return checkOrderValue(orderClient.getOrders());
    }

    @Override
    public List<Order> getOrdersFromUser(int userID) throws IOException {
        if(userID>=1)
            return checkOrderValue(orderClient.getOrdersFromUser(userID));
        else throw new IllegalArgumentException("getOrdersFromUser was given an invalid ID: "+userID);
    }

    @Override
    public Order getOrderById(int id) throws IOException {
        if(id>=1){
            Order o = orderClient.getOrderById(id);
            o.checkPrice();
        return o;
        }else throw new IllegalArgumentException("getOrdersFromUser was given an invalid ID: "+id);
    }

    @Override
    public void addOrder(Order order) {
        orderClient.addOrder(checkOrderValue(order));
    }

    @Override
    public void deleteOrderByIdAsync(int id) {
        if(id>=1)
            orderClient.deleteOrderByIdAsync(id);
        else throw new IllegalArgumentException("getOrdersFromUser was given an invalid ID: "+id);
    }

    @Override
    public void updateOrderAsync(Order order) {
        orderClient.updateOrderAsync(order);
    }

    private Order checkOrderValue(Order order){
        double newValue=0;

        if (order.getProducts()!=null)
            for(Product product: order.getProducts()) newValue += product.getValue();
        else
            System.out.println("Order has no products");

        order.setPrice(newValue);
        return order;
    }
    private List<Order> checkOrderValue(List<Order> orders){

        for(Order order: orders){
            double newValue=0;
            if (order.getProducts()!=null)
                for(Product product: order.getProducts()) newValue += product.getValue();
            else
                System.out.println("Order has no products");
            order.setPrice(newValue);
        }
        return orders;
    }
}
