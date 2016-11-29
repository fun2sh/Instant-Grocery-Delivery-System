package com.InstantGrocery.dao;

import com.InstantGrocery.model.User;

import java.util.List;

public interface UserDao {


    User getUserByUsername(String userName);

    List<User> getAllUsers();

    void editUser(User user);

}
