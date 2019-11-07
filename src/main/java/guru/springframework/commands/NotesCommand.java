package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

    private Long id;

    @NotNull(message = "Please enter the notes for recipe.")
    private String recipeNotes;
}
