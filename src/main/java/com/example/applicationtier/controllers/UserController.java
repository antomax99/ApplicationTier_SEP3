package com.example.applicationtier.controllers;

import com.example.applicationtier.entities.User;
import com.example.applicationtier.Contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<Object>> getAllUsers() throws IOException {
        System.out.println("GETTING USERS ON CONTROLLER");
        List<User> users = userService.getAllUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user)
    {
        System.out.println("addUser ON CONTROLLER");
        try {
            userService.addUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/{id}/retrieve", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable int id) throws IOException {
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/user/update", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@RequestBody User user)
    {
        try{
            userService.updateUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/user/{id}/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserById(@PathVariable int id)
    {
        userService.deleteUserById(id);
        return new ResponseEntity("deleted user successful",HttpStatus.OK);
    }

    @RequestMapping(value = "/login/{username}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserByUsername(@PathVariable String username) throws IOException {
        try{
            User user = userService.getUserByUsername(username);
            System.out.println(user.toString());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }catch (IllegalArgumentException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
