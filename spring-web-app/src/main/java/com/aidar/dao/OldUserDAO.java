package com.aidar.dao;

import com.aidar.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Vadym Mitin
 */
//@Component
public class OldUserDAO {
    private static Connection connection;

    // initialize db connection
    static {
        String url = null;
        String username = null;
        String password = null;
        Properties prop = new Properties();

        // load db properties
        try (InputStream in = OldUserDAO.class.getClassLoader().getResourceAsStream("persistence.properties")) {
            prop.load(in);

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // initialize db connection
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement selectFromDatabase = connection.prepareStatement("select* from users");
        ResultSet setOfUsers = selectFromDatabase.executeQuery();
        while (setOfUsers.next()) {
            User user = createUser(setOfUsers);
            users.add(user);
        }
        return users;
    }

    public User getUserByEmail(String email) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from users where email= ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return createUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User createUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setName(rs.getString(1));
        user.setSurname(rs.getString(2));
        user.setEmail(rs.getString(3));
        return user;
    }

    public void addUserToDB(User user) throws SQLException {

        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();

        PreparedStatement ps = connection.prepareStatement("INSERT into users values (?, ?, ?)");

        ps.setString(1, name);
        ps.setString(2, surname);
        ps.setString(3, email);
        ps.execute();
    }

}
