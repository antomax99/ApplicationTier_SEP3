package com.example.applicationtier.controllers;

import com.example.applicationtier.models.User;
import com.example.applicationtier.services.UserService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user)
    {
        System.out.println("SAVING USER ON CONTROLLER");
        userService.addUser(user);
        return new ResponseEntity("user created", HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable int id) throws IOException {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @RequestMapping(value = "/users/update", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody User user)
    {
        userService.updateUser(user);
        return new ResponseEntity("user update successful", HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserById(@PathVariable int id)
    {
        userService.deleteUserById(id);
        return new ResponseEntity("deleted user successful",HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserByUsername(@PathVariable String username) throws IOException {
        User user = userService.getUserByUsername(username);
        System.out.println(user.toString());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
