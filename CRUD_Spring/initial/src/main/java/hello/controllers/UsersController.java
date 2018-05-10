package hello.controllers;

import hello.models.User;
import hello.models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/users")

public class UsersController {
    @Autowired
    private UserRepository userRepository;

    // SHOW ALL USERS
    @GetMapping(path = "/")
    public String getAllUsers(Model model) {
        model.addAttribute("user", userRepository.findAll());
        return "allUsers";
    }

    // GET REGISTRATION FORM
    @GetMapping(path = "/new")
    public String newUserForm(Model user) {
        user.addAttribute("user", new User());
        return "addUser";
    }

    // CREATE NEW USER
    @PostMapping(path = "/")
    public String addNewUser(@ModelAttribute User user, Model model) {
        User nU = new User();
        nU.setName(user.getName());
        nU.setPassword(user.getPassword());
        nU.setEmail(user.getEmail());
        userRepository.save(nU);
        model.addAttribute("user", userRepository.findAll());
        return "allUsers";
    }

    // FIND USER BY ID
    @GetMapping(path = "/{id}")
    public String getUser(@PathVariable long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "singleUser";
    }

    // GET EDIT FORM
    @GetMapping(path = "/edit/{id}")
    public String editUserForm(@PathVariable long id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "editUser";
    }

    // UPDATE USER
    @PostMapping(path = "/edit/{id}")
    public String updateUser(@ModelAttribute User user, Model model, @PathVariable long id) {
        User editU = userRepository.findById(id).get();
        editU.setName(user.getName());
        editU.setPassword(user.getPassword());
        editU.setEmail(user.getEmail());
        userRepository.save(editU);
        model.addAttribute("user", userRepository.findAll());
        return "allUsers";
    }

    // DELETE USER BY ID
    @PostMapping(path = "/{id}")
    public String deleteUser(@PathVariable long id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("user", userRepository.findAll());
        return "allUsers";
    }
}