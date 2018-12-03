package com.aidar.dao;

import com.aidar.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Vadym Mitin
 */
@Component
public class UserDAO {
    public static Connection connection;

    // initialize db connection
    static {
        String url;
        String username;
        String password;
        Properties prop = new Properties();

        try (InputStream in = UserDAO.class.getClassLoader().getResourceAsStream("./postgres.properties")) {
            prop.load(in);

            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");

            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, username, password);

        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public List<User> getAll() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement selectFromDatabase = connection.prepareStatement("select* from users");
        ResultSet setOfUsers = selectFromDatabase.executeQuery();
        while (setOfUsers.next()) {
            User user = new User();
            user.setName(setOfUsers.getString(1));
            user.setSurname(setOfUsers.getString(2));
            user.setEmail(setOfUsers.getString(3));
            users.add(user);
        }
        return users;
    }

    public void addUserToDB(User user) throws SQLException {
        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();
        Statement statement = connection.createStatement();
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT into users values ('");
        sb.append(name);
        sb.append("', '");
        sb.append(surname);
        sb.append("', '");
        sb.append(email);
        sb.append("');");
        String sql = sb.toString();
        System.out.println(sql);
        int result = statement.executeUpdate(sql);
        System.out.println(result);
    }

}
