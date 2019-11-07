package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class MealCategoryCommand {

    private Long id;

    @NotNull(message = "Please select a category.")
    @Size(min=3, max=15)
    private String description;
}
