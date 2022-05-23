package com.example.applicationtier.networking;

import com.example.applicationtier.models.Order;
import com.example.applicationtier.models.OrderModel;
import com.example.applicationtier.models.User;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class OrderClient implements OrderModel {

    private Socket socket;
    private final String host = "localhost";
    private final int port = 2913;

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
    public ArrayList<Order> getAllOrders() {
        return null;
    }

    @Override
    public Order getOrderById(int id) throws IOException {
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
