package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserCommand {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String confirm;
}
