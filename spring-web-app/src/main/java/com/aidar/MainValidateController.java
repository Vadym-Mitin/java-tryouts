package com.aidar;

import com.aidar.dao.UserDAO;
import com.aidar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=CKR4pmXntjw&index=6&list=PLVKSU8yHkskF5LT1cNTdGXINtOrxAxjjV
 * https://devcolibri.com/spring-3-mvc-hello-world/
 * <p>
 * <p>
 * see the Mapped Server Log section for the route to your method mapping. like "{[/blablabla/blabla]}"
 * <p>
 * it is important to keep of the application context section in your servers launch configuration
 * because if you write something other than "" server will send you to this address
 *
 * @author Vadym Mitin
 */
@Controller
public class MainValidateController {
    @Autowired
    private UserDAO userDAO;
//    public static final List<User> USERS = new ArrayList<>();

    @GetMapping("/")
    public String view(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name, Model model) {
        model.addAttribute("msg", "Hello " + name);
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model) throws SQLException {
        model.addAttribute("users", userDAO.getAll());
        return "/users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "/sign_up_validate";
    }

    @PostMapping("/users/new")
    public String signUp(@ModelAttribute @Valid User user, BindingResult result) throws SQLException {
        if (result.hasErrors()) {
            return "/sign_up_validate";
        }
//        USERS.add(user);
        userDAO.addUserToDB(user);
        return "redirect:/users";
    }

}
