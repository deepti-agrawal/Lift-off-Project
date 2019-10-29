package guru.springframework.services;

import guru.springframework.commands.UserCommand;
import guru.springframework.domain.User;

public interface UserService {

    User saveUser(UserCommand user);

    User getUserByUserName(String username);
}
