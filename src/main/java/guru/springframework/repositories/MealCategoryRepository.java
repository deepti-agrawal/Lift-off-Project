package guru.springframework.repositories;

import guru.springframework.domain.MealCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MealCategoryRepository extends CrudRepository<MealCategory,Long> {

    Optional<MealCategory> findByDescription(String description);
}
