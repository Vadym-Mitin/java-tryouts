package com.aidar.util;

import com.aidar.dao.UserDAO;
import com.aidar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * https://www.youtube.com/watch?v=01GW7LReNx8&list=PLVKSU8yHkskF5LT1cNTdGXINtOrxAxjjV&index=12
 *
 * @author Vadym Mitin
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    @Qualifier("hibernateUserDAO")
    private UserDAO userDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        String email = user.getEmail();

        User userByEmail = userDAO.getUserByEmail(email);

        if (userByEmail != null) {
            errors.rejectValue("email", "",
                    "this email is already in use");
        }
    }
}
