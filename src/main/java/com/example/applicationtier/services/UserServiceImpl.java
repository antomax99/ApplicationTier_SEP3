package com.example.applicationtier.services;

import com.example.applicationtier.Contracts.UserService;
import com.example.applicationtier.entities.User;
import com.example.applicationtier.networking.UserClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserClient userClient;

    public UserServiceImpl() throws IOException {
        userClient = new UserClient();
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userClient.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        if(validateCredentials(user))
            userClient.addUser(user);
        else
            System.out.println("addUser was given an incorrect User: ");
    }

    @Override
    public User getUserById(int id) throws IOException {
        if (id>=1)
            return userClient.getUserById(id);
        else throw new IllegalArgumentException("getUserById was given an invalid ID: "+id);
    }

    @Override
    public void updateUser(User user) {
        if(validateCredentials(user))
            userClient.updateUser(user);
        else
            throw new IllegalArgumentException("updateUser was given an incorrect User: ");
    }

    @Override
    public void deleteUserById(int id) {
        if(id>=1)
            userClient.deleteUserById(id);
        else
            System.out.println("deleteUserById was given an invalid ID: "+id);
    }

    @Override
    public User getUserByUsername(String username) throws IOException {
        if(validateCredentials(username))
            return userClient.getUserByUsername(username);
        else throw new IllegalArgumentException("Username out of range");
    }

    private boolean validateCredentials(User user){
        boolean toReturn=true;
        if (user!= null){
            if(user.getUserName().length() > 64 || user.getPassword().length() > 128)
                toReturn=false;
            if(user.getFirstName().length() > 64 || user.getLastName().length() > 64)
                toReturn=false;
            if(user.getEmail().length() > 64 || user.getSecurityLevel() <= 0)
                toReturn=false;
        }
                return toReturn;
    }
    private boolean validateCredentials(String username){
        if(username.length() <=64)
            return true;
        else
            return false;
    }
}
