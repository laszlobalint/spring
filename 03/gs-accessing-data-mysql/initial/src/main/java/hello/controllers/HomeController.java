package hello.controllers;

import hello.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/home")

public class HomeController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/")
    public String showHome(Model model) {
        return "home";
    }

    @GetMapping(path = "/login")
    public String showLogin(Model model) {
        return "login";
    }

    @GetMapping(path = "/hello")
    public String showHello(Model model) {
        return "hello";
    }
}
