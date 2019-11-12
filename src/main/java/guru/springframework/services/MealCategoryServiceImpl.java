package guru.springframework.services;

import guru.springframework.domain.MealCategory;
import guru.springframework.repositories.MealCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MealCategoryServiceImpl implements MealCategoryService {

    private final MealCategoryRepository repository;

    public MealCategoryServiceImpl(MealCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<MealCategory> getCategories() {
        return repository.findAll();
    }

    @Override
    public MealCategory getMealCategoryById(Long id) {
        Optional<MealCategory> category = repository.findById(id);
        if(!category.isPresent()){
            log.info("Error in finding mealCategory by id:-",id);
        }
        return category.get();
    }
}
