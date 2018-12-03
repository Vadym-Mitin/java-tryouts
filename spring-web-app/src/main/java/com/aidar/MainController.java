package com.aidar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
//@RequestMapping
public class MainController {

    @GetMapping
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

}
