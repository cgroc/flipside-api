package uk.co.grokemon.flipside.service;

import org.springframework.stereotype.Service;
import uk.co.grokemon.flipside.domain.User;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private static final List<User> userList = Arrays.asList(
            new User(1, "Chris"),
            new User(2, "Jane"),
            new User(3, "Thomas")
    );

    public List<User> getUserList() {
        return userList;
    }
}
