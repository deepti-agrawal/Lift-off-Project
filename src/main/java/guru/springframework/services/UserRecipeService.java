package guru.springframework.services;

import guru.springframework.domain.User;
import guru.springframework.domain.UserRecipe;

import java.util.List;

public interface UserRecipeService {

    void addRecipeForUser(Long recipeId, Long userId);

    List<UserRecipe> getRecipeForUser(User user);
}
