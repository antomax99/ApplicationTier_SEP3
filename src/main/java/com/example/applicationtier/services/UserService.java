package com.example.applicationtier.services;

import com.example.applicationtier.models.User;

import java.io.IOException;

public interface UserService {
    void addUser(User user);
    User getUserById(int id) throws IOException;
    void updateUser(User user);
    void deleteUserById(int id);
    User getUserByUsername(String username) throws IOException;
}
