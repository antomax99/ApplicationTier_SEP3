package com.example.applicationtier.networking;

import com.example.applicationtier.models.User;
import com.example.applicationtier.models.UserModel;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClient implements UserModel {

    private Socket socket;
    private final String host = "localhost";
    private final int port = 2911;

    private PrintWriter out;
    private BufferedReader in;

    private Gson gson;

    public UserClient() throws IOException {
        socket = new Socket(host, port);
        gson = new Gson();
        out = new PrintWriter(socket.getOutputStream(),true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }



    @Override
    public void addUser(User user) {
        out.println("add user");
        String userAsJson = gson.toJson(user);
        out.println(userAsJson);
    }

    @Override
    public User getUserById(int id) throws IOException {
        out.println("get user by id");
        String idAsJson = gson.toJson(id);
        out.println(idAsJson);
        String userAsJson = in.readLine();
        User userFound = gson.fromJson(userAsJson,User.class);
        return userFound;
    }

    @Override
    public void updateUser(User user) {
        out.println("update user");
        String userAsJson = gson.toJson(user);
        out.println(userAsJson);
    }

    @Override
    public void deleteUserById(int id) {
        out.println("delete user by id");
        String userAsJson = gson.toJson(id);
        out.println(userAsJson);
    }

    @Override
    public User getUserByUsername(String username) throws IOException {
        out.println("get user by username");
        String idAsJson = gson.toJson(username);
        out.println(idAsJson);
        String userAsJson = in.readLine();
        User userFound = gson.fromJson(userAsJson,User.class);
        return userFound;

    }
}
