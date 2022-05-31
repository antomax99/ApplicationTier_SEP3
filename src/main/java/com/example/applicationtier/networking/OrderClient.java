package com.example.applicationtier.networking;

import com.example.applicationtier.entities.Order;
import com.example.applicationtier.entities.User;
import com.example.applicationtier.models.OrderModel;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class OrderClient implements OrderModel {

    private Socket socket;
    private final String host = "localhost";
    private final int port = 2912;

    private PrintWriter out;
    private BufferedReader in;

    private Gson gson;

    public OrderClient() throws IOException {
        socket = new Socket(host, port);
        gson = new Gson();
        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public  List<Order> getOrders() {

        out.println("get orders");
        String orderAsJson = null;
        try {
            orderAsJson = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Order[] ordersFound = new Gson().fromJson(orderAsJson, Order[].class);

        return List.of(ordersFound);
    }

    @Override
    public List<Order> getOrdersFromUser(int userID) {
        out.println("get orders from user");
        String idAsJson = gson.toJson(userID);
        out.println(idAsJson);
        String orderAsJson = null;
        try {
            orderAsJson = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // This parses your JSON
        Order[] ordersFound = new Gson().fromJson(orderAsJson, Order[].class);

        return List.of(ordersFound);
    }

    @Override
    public Order getOrderById(int id) throws IOException {
        System.out.println("getOrderById");
        out.println("get order by id");
        String idAsJson = gson.toJson(id);
        out.println(idAsJson);
        String orderAsJson = in.readLine();
        Order orderFound = gson.fromJson(orderAsJson,Order.class);
        return orderFound;
    }

    @Override
    public void addOrder(Order order) {
        out.println("add order");
        String orderAsJson = gson.toJson(order);
        out.println(orderAsJson);
    }

    @Override
    public void deleteOrderByIdAsync(int id) {
        out.println("delete order by id");
        String orderIdAsJson = gson.toJson(id);
        out.println(orderIdAsJson);
    }

    @Override
    public void updateOrderAsync(Order order) {
        out.println("update order");
        String orderAsJson = gson.toJson(order);
        out.println(orderAsJson);
    }
}
