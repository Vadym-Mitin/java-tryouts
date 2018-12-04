package com.aidar.dao;

import com.aidar.model.User;

import java.util.List;

/**
 * @author Vadym Mitin
 */
public interface UserDAO {
    List<User> getAll();

    User getUserByEmail(String email);

    void addUserToDB(User user);
}
