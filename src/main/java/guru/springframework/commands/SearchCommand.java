package guru.springframework.commands;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SearchCommand {

    private Long id;

    @NotNull
    @Size(min=3, max=15,message = "Please specify the search value.")
    private String description;

    public SearchCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
