package guru.springframework.services;

import guru.springframework.domain.Recipe;

import java.util.List;

public interface SearchService {

    List<Recipe> searchRecipeByKeyword(String keyword);
}
