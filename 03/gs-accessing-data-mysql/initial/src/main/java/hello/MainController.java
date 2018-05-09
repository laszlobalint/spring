package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping(path = "/")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody User getUserById(@PathVariable("id") long id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            System.out.println("User with id " + id + " is not found!");
            return null;
        }
        return user;
    }

    @PostMapping(path = "/")
    public @ResponseBody String addNewUser(@RequestBody String name, @RequestBody String password, @RequestBody String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setPassword(password);
        newUser.setEmail(email);
        userRepository.save(newUser);
        return "Saved a new user!";
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody User updateUser(@PathVariable("id") long id, @RequestBody String name, @RequestBody String email) {
        User currentUser = userRepository.findById(id).get();
        if (currentUser == null) {
            System.out.println("User with id " + id + " is not found!");
            return null;
        }
        currentUser.setName(name);
        currentUser.setEmail(email);
        userRepository.save(currentUser);
        return currentUser;
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteUser(@PathVariable("id") long id) {
        userRepository.deleteById(id);
        return "User was deleted!";
    }

    @DeleteMapping(path = "/")
    public @ResponseBody String deleteAllUsers() {
        userRepository.deleteAll();
        return "All users were deleted!";
    }
}
