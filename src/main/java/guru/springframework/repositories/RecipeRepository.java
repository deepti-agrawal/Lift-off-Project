package guru.springframework.repositories;

import guru.springframework.domain.MealCategory;
import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    Set<Recipe> findAllByMealCategoryEquals(MealCategory mealCategory);

    List<Recipe> findAllByDescriptionLike(String description);

}