package guru.springframework.services;

import guru.springframework.commands.UserCommand;
import guru.springframework.converters.UserCommandToUser;
import guru.springframework.domain.User;
import guru.springframework.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserCommandToUser commandToUser;

    public UserServiceImpl(UserRepository userRepository, UserCommandToUser commandToUser) {
        this.userRepository = userRepository;
        this.commandToUser = commandToUser;
    }

    @Override
    public User saveUser(UserCommand userCommand) {
        User user = commandToUser.convert(userCommand);
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findUserByUsername(username);
    }
}