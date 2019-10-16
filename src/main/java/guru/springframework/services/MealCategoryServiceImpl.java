package guru.springframework.services;

import guru.springframework.domain.MealCategory;
import guru.springframework.repositories.MealCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
}
