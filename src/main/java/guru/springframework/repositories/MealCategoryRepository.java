package guru.springframework.repositories;

import guru.springframework.domain.MealCategory;
import org.springframework.data.repository.CrudRepository;

public interface MealCategoryRepository extends CrudRepository<MealCategory,Long> {
}
