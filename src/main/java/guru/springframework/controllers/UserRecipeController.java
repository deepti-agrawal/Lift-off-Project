package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.domain.User;
import guru.springframework.domain.UserRecipe;
import guru.springframework.services.RecipeService;
import guru.springframework.services.UserRecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class UserRecipeController {

    private final UserRecipeService service;
    private final RecipeService recipeService;

    public UserRecipeController(UserRecipeService service, RecipeService recipeService) {
        this.service = service;
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/{recipeId}/favorite",method = RequestMethod.GET)
    public String addRecipeToFavorite(HttpServletRequest request, @PathVariable String recipeId){
        log.debug("Adding Recipe To id: " + recipeId);
        User user = (User) request.getSession().getAttribute("user");
        if(user != null)
        service.addRecipeForUser(Long.valueOf(recipeId),user.getUserId());
        return "redirect:/";
    }

    @GetMapping("/myfavorite")
    public String getFavoriteRecipe(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user != null) {
            log.debug("Fetching Favorite Recipe To User: " + user.getUserId());
            List<UserRecipe> recipes = service.getRecipeForUser(user);
            List<Recipe> recipeList = new ArrayList<>();
            for(UserRecipe userRecipe:recipes){
                Recipe recipe = recipeService.findById(userRecipe.getRecipeId());
                recipeList.add(recipe);
            }
            model.addAttribute("myRecipes",recipeList);
        }
        return "myfavorite";
    }

}
