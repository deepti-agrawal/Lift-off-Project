package guru.springframework.commands;

import guru.springframework.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;

    @NotNull
    @Size(min=3, max=100, message = "Please enter the description name.")
    private String description;

    @NotNull(message = "Please enter the preparation time.")
    private Integer prepTime;

    @NotNull(message = "Please enter the cook time.")
    private Integer cookTime;

    @NotNull(message = "Please enter the number of servings.")
    private Integer servings;

    @NotNull
    @Size(min=3, max=100, message = "Please enter the source.")
    private String source;

    @NotNull
    @Size(min=3, max=100, message = "Please enter the url.")
    private String url;

    @NotNull
    @Size(min=3, max=100, message = "Please enter the directions name.")
    private String directions;

    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Byte[] image;
    private Difficulty difficulty;
    private NotesCommand notes;
    private Set<MealCategoryCommand> mealcategories = new HashSet<>();
}