package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {

    private Long id;

    @NotNull
    @Size(min=3, max=15)
    private String description;
}