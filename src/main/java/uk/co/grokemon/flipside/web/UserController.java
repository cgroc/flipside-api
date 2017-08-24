package uk.co.grokemon.flipside.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.grokemon.flipside.domain.User;
import uk.co.grokemon.flipside.service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUserList();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {
        //TODO this isn't quite what I want, how to return a 404 if no user is found?
        return userService.getUserList().stream().filter(user -> user.getId() == id).findFirst().orElse(new User());
    }
}
