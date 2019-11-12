package guru.springframework.services;

import guru.springframework.domain.MealCategory;

public interface MealCategoryService {

    Iterable<MealCategory> getCategories();

    MealCategory getMealCategoryById(Long id);
}
