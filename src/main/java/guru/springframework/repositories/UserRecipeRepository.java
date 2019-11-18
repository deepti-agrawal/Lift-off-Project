package guru.springframework.repositories;

import guru.springframework.domain.UserRecipe;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRecipeRepository extends CrudRepository<UserRecipe, Long> {

    List<UserRecipe> findAllByUserId(Long userId);
}
