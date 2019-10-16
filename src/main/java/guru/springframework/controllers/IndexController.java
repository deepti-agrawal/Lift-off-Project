package guru.springframework.controllers;

import guru.springframework.domain.MealCategory;
import guru.springframework.services.MealCategoryService;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final MealCategoryService mealCategoryService;
    private final RecipeService recipeService;

    public IndexController(MealCategoryService mealCategoryService, RecipeService recipeService) {
        this.mealCategoryService = mealCategoryService;
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndex(Model model){
        log.info("Getting the index page....");
        model.addAttribute("title","Recipe Home");
        model.addAttribute("categories",mealCategoryService.getCategories());
        return "index";
    }

    @RequestMapping("/category/{id}/show")
    public String getMealByCategory(@PathVariable String id,Model model){
        log.info("Getting the getMealByCategory....");
        model.addAttribute("title","Recipe Home");
        MealCategory mealCategory = new MealCategory();
        mealCategory.setId(Long.valueOf(id));
        model.addAttribute("recipes",recipeService.getRecipesByMealCategory(mealCategory));
        return "recipe/showRecipes";
    }
}