package com.example.applicationtier.controllers;

import com.example.applicationtier.entities.Order;
import com.example.applicationtier.Contracts.OrderService;
import com.example.applicationtier.entities.Product;
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
        System.out.println("getAllOrders ON CONTROLLER");
        List<Order> orders = orderService.getOrders();
        return new ResponseEntity(checkOrderValue(orders), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/retrieveprdocut/user/{userID}", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getOrdersFromUser(@PathVariable int userID) throws IOException {
        System.out.println("getOrdersFromUser ON CONTROLLER");
        List<Order> orders = orderService.getOrdersFromUser(userID);
        return new ResponseEntity(checkOrderValue(orders), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody Order order)
    {
        orderService.addOrder(checkOrderValue(order));
        return new ResponseEntity( HttpStatus.OK);
    }


    @RequestMapping(value = "/order/{id}/retrieve", method = RequestMethod.GET)
    public ResponseEntity<Object> getOrderById(@PathVariable int id) throws IOException {
        Order order = orderService.getOrderById(id);
        return new ResponseEntity<>(checkOrderValue(order),HttpStatus.OK);
    }

    @RequestMapping(value = "/order/update", method = RequestMethod.PUT)
    public ResponseEntity updateOrder(@RequestBody Order order)
    {
        orderService.updateOrderAsync(checkOrderValue(order));
        return new ResponseEntity("order update successful", HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrderById(@PathVariable int id)
    {
        orderService.deleteOrderByIdAsync(id);
        return new ResponseEntity("deleted order successful",HttpStatus.OK);
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
