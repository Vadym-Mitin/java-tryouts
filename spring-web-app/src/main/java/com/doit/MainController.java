package com.doit;

import com.doit.dao.UserDAO;
import com.doit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * https://www.youtube.com/watch?v=CKR4pmXntjw&index=6&list=PLVKSU8yHkskF5LT1cNTdGXINtOrxAxjjV
 * https://devcolibri.com/spring-3-mvc-hello-world/
 * <p>
 * <p>
 * see the Mapped Server Log section for the route to your method mapping. like "{[/blablabla/blabla]}"
 * <p>
 * it is important to keep of the application context section in your servers launch configuration
 * because if you write something other than "/" server will send you to this address
 *
 * @author Vadym Mitin
 */
@Controller
public class MainController {

    @Autowired
    @Qualifier("hibernateUserDAO")
    private UserDAO userDAO;

    @Autowired
    private Validator userValidator;

    @GetMapping("/")
    public String view(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name, Model model) {
        model.addAttribute("msg", "Hello " + name);
        return "index";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "/users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model) {
        model.addAttribute("user", new User());
        return "/sign_up_validate";
    }

    @PostMapping("/users/new")
    public String signUp(@ModelAttribute @Valid User user, BindingResult result) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/sign_up_validate";
        }
        userDAO.addUserToDB(user);
        return "redirect:/users";
    }

}
