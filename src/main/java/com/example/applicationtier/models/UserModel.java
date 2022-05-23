package com.example.applicationtier.models;

import java.io.IOException;

public interface UserModel {

    void addUser(User user);
    User getUserById(int id) throws IOException;
    void updateUser(User user);
    void deleteUserById(int id);
    User getUserByUsername(String username) throws IOException;
}
