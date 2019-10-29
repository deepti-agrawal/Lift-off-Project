package guru.springframework.controllers;

import guru.springframework.commands.SearchCommand;
import guru.springframework.domain.Recipe;
import guru.springframework.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Slf4j
@Controller
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String showSearchPage(Model model){
        model.addAttribute("title","Search");
        model.addAttribute("search",new SearchCommand());
        return "search";
    }

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    private String showSearchResult(@ModelAttribute SearchCommand command, Model model){
        List<Recipe> recipes = searchService.searchRecipeByKeyword("%" + command.getDescription() + "%");
        if(recipes!=null){
            model.addAttribute("recipes", recipes);
        }
        return "recipe/showRecipes";
    }
}
