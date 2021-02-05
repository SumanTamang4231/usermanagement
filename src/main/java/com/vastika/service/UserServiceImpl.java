package com.vastika.service;

import com.vastika.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserService userService ;
    public UserServiceImpl(){
        userService = new UserServiceImpl();
    }

    @Override
    public int saveUser(User user) {
        return userService.saveUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userService.updateUser(user) ;
    }

    @Override
    public int deleteUser(int id) {
        return userService.deleteUser(id);
    }

    @Override
    public User getUserById(int id) {
        return userService.getUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
