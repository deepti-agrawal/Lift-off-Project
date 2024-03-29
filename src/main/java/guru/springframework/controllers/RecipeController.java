package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.MealCategory;
import guru.springframework.services.MealCategoryService;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final MealCategoryService mealCategoryService;

    public RecipeController(RecipeService recipeService, MealCategoryService mealCategoryService) {
        this.recipeService = recipeService;
        this.mealCategoryService = mealCategoryService;
    }

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/show";
    }

    @GetMapping("recipe/new")
    public String newRecipe(Model model){
        model.addAttribute("recipe", new RecipeCommand());
        model.addAttribute("mealCategories", mealCategoryService.getCategories());
        return "recipe/newrecipeform";
    }

    @GetMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        model.addAttribute("mealCategories", mealCategoryService.getCategories());
        return  "recipe/updaterecipeform";
    }

    @PostMapping("recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command){
        Set<MealCategory> mealCategories = getCategoriesSet(command);
        command.setCategories(mealCategories);
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @GetMapping("recipe/{id}/delete")
    public String deleteById(@PathVariable String id){
        log.debug("Deleting id: " + id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }

    private Set<MealCategory> getCategoriesSet(RecipeCommand command){
        Set<MealCategory> mealCategories = new HashSet<>();
        for(int i = 0;i<command.getMealcategories().length;i++) {
            mealCategories.add(mealCategoryService.getMealCategoryById(Long.valueOf(command.getMealcategories()[i])));
        }
        return mealCategories;
    }
}