package com.aidar.dao;

import com.aidar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * https://www.youtube.com/watch?v=YaTAE9EqYX0&list=PLVKSU8yHkskF5LT1cNTdGXINtOrxAxjjV&index=13
 *
 * @author Vadym Mitin
 */
@Component
public class JdbcTemplateUserDAO implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
//        List<User> users = jdbcTemplate.query("select* from users", (rs, rowNum) -> {
//            User user = createUser(rs);
//            return user;
//        });

        BeanPropertyRowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query("select* from users", rowMapper);
        return users;
    }

    public User getUserByEmail(String email) {
        List<User> users = jdbcTemplate.query("select * from users where email= ?"
                , new Object[]{email}
                , new BeanPropertyRowMapper<>(User.class)
        );
        Optional<User> user = users.stream().findAny();
        return user.orElse(null);
    }

    public void addUserToDB(User user) {
        String name = user.getName();
        String surname = user.getSurname();
        String email = user.getEmail();
        jdbcTemplate.update("INSERT into users values (?, ?, ?)", name, surname, email);
    }
}
