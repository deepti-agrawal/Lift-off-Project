package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    private final RecipeRepository repository;

    public SearchServiceImpl(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public List<Recipe> searchRecipeByKeyword(String keyword) {
        List<Recipe> recipes = repository.findAllByDescriptionLike(keyword);
        if(recipes!=null && recipes.size()!=0){
            return recipes;
        }
        return null;
    }
}
