package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {

    private Long id;

    @NotNull
    private Long recipeId;

    @NotNull
    @Size(min=3, max=100, message = "Please enter the ingredient name.")
    private String description;

    @NotNull(message = "Please enter the amount for ingredient.")
    private BigDecimal amount;

    private UnitOfMeasureCommand uom;
}