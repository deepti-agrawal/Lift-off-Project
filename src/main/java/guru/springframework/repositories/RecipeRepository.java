package guru.springframework.repositories;

import guru.springframework.domain.MealCategory;
import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    public List<Recipe> findRecipesByMealCategory(MealCategory mealCategory);
}