package com.doit.dao;

import com.doit.model.User;

import java.util.List;

/**
 * representation of database interaction for User entities
 *
 * @author Vadym Mitin
 */
public interface UserDAO {
    List<User> getAll();

    User getUserByEmail(String email);

    void addUserToDB(User user);
}
