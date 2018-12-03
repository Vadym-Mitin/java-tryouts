package com.aidar;

import com.aidar.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
//@Controller
//@RequestMapping
public class MainController {

    public static final List<User> USERS = new ArrayList<>();


//    public static final Collection<User> USERS = Arrays.asList(
//            new User("Joe", "Pupkin", "pu@joe.com"),
//            new User("Jebodaya", "Kerman", "JKerman@ksp.com"),
//            new User("Vasya", "Vasiliev", "Vasya@mail.ru")
//    );

    @GetMapping("/")
    public String view(@RequestParam(value = "name", required = false, defaultValue = "Stranger") String name, Model model) {
        model.addAttribute("msg", "Hello " + name);
        return "index";
    }

    @GetMapping("/spring")
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Spring 3 MVC - Hello World");
        return "hello";

    }

    @GetMapping("/raw")
    @ResponseBody
    public String raw() {
        return "Raw data";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", USERS);
        return "/users";
    }

    @GetMapping("/users/new")
    public String getSignUp(Model model) {

        return "/sign_up";
    }

    //    old method to handle forms
//    @PostMapping("/users/new")
//    public String signUp(@RequestParam("name") String name,
//                         @RequestParam("surname") String surname,
//                         @RequestParam("email") String email) {
//        USERS.add(new User(name, surname, email));
//        return "redirect:/users";
//    }
    @PostMapping("/users/new")
    public String signUp(@ModelAttribute User user) {
        USERS.add(user);
        return "redirect:/users";
    }

}
