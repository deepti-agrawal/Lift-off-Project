package guru.springframework.services;

import guru.springframework.domain.User;
import guru.springframework.domain.UserRecipe;
import guru.springframework.repositories.UserRecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserRecipeServiceImpl implements UserRecipeService{

    private final UserRecipeRepository repository;

    public UserRecipeServiceImpl(UserRecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void addRecipeForUser(Long recipeId, Long userId){
        log.info("Saving user with Recipe:",recipeId,userId);
        UserRecipe userRecipe = new UserRecipe();
        userRecipe.setRecipeId(recipeId);
        userRecipe.setUserId(userId);
        repository.save(userRecipe);
    }

    @Override
    @Transactional
    public List<UserRecipe> getRecipeForUser(User user){
        log.info("In UserRecipeServiceImpl method-> getRecipeforUser with userID:-",user.getUserId());
        return repository.findAllByUserId(user.getUserId());
    }
}