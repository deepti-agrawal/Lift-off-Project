package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
public class UserCommand {

    private Long id;

    @NotNull
    @Size(min=3,max=20, message = "Please enter valid username.")
    private String username;

    @NotNull
    @Size(min=5,max=50, message = "Please enter valid email.")
    private String email;

    @NotNull
    @Size(min=5,max=20, message = "Please enter valid password.")
    private String password;

    @NotNull
    @Size(min=5,max=20, message = "Password does not match.")
    private String confirm;
}
