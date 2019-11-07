package guru.springframework.controllers;

import guru.springframework.commands.SearchCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public String showSearchPage(Model model){
        model.addAttribute("title","Search");
        model.addAttribute("searchObject",new SearchCommand());
        return "search";
    }

    @PostMapping("/search")
    private String showSearchResult(Model model, @ModelAttribute("searchObject") @Valid SearchCommand command, Errors errors){
        log.info("Inside showSearchResult of search controller..");
        if(errors.hasErrors()){
            log.info("In the error block of search controller");
            return "search";
        }
        List<Recipe> recipes = searchService.searchRecipeByKeyword("%" + command.getDescription() + "%");
        if(recipes!=null){
            model.addAttribute("recipes", recipes);
        }
        return "recipe/showRecipes";
    }
}
