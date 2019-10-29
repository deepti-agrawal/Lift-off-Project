package guru.springframework.converters;

import guru.springframework.commands.UserCommand;
import guru.springframework.domain.User;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UserCommandToUser implements Converter<UserCommand, User> {

    @Synchronized
    @Nullable
    @Override
    public User convert(UserCommand userCommand) {
        if(userCommand!=null){
            User user = new User();
            user.setEmail(userCommand.getEmail());
            user.setPassword(userCommand.getPassword());
            user.setUsername(userCommand.getUsername());
            user.setRole("Guest");
            return user;
        }
        return null;
    }
}
