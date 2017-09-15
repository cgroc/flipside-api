package uk.co.grokemon.flipside.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uk.co.grokemon.flipside.domain.User;
import uk.co.grokemon.flipside.service.UserNotFoundException;
import uk.co.grokemon.flipside.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        //Throws a NoSuchElementException if User doesn't exist - turn this into a 404
        return userService.getUserById(id);
    }

    @ExceptionHandler
    private void handleNoSuchElementException(UserNotFoundException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }
}
