package com.example.applicationtier.Contracts;

import com.example.applicationtier.entities.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws IOException;
    void addUser(User user);
    User getUserById(int id) throws IOException;
    void updateUser(User user);
    void deleteUserById(int id);
    User getUserByUsername(String username) throws IOException;
}
