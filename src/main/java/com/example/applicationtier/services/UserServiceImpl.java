package com.example.applicationtier.services;

import com.example.applicationtier.models.User;
import com.example.applicationtier.networking.UserClient;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    private UserClient userClient;

    public UserServiceImpl() throws IOException {
        userClient = new UserClient();
    }

    @Override
    public void addUser(User user) {
        userClient.addUser(user);
    }

    @Override
    public User getUserById(int id) throws IOException {
        return userClient.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userClient.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        userClient.deleteUserById(id);
    }

    @Override
    public User getUserByUsername(String username) throws IOException {
        return userClient.getUserByUsername(username);
    }
}
