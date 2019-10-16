package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.MealCategory;
import guru.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Set<Recipe> getRecipesByMealCategory(MealCategory mealCategory);

    Recipe findById(Long id);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);
}