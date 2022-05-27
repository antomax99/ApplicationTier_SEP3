package com.example.applicationtier.controllers;

import com.example.applicationtier.entities.Order;
import com.example.applicationtier.Contracts.OrderService;
import com.example.applicationtier.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getAllOrders() throws IOException {
        System.out.println("GETTING ORDERS ON CONTROLLER");
        List<Order> orders = orderService.getOrders();
        return new ResponseEntity(orders, HttpStatus.OK);
    }
    @RequestMapping(value = "/orders/add", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody Order order)
    {
        orderService.addOrder(order);
        return new ResponseEntity("order created", HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getOrderById(@PathVariable int id) throws IOException {
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(order,HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/update", method = RequestMethod.PUT)
    public ResponseEntity updateOrder(@RequestBody Order order)
    {
        orderService.updateOrderAsync(order);
        return new ResponseEntity("order update successful", HttpStatus.OK);
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrderById(@PathVariable int id)
    {
        orderService.deleteOrderByIdAsync(id);
        return new ResponseEntity("deleted order successful",HttpStatus.OK);
    }


}
