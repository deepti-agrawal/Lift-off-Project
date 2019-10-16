package guru.springframework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

    @RequestMapping("/search")
    public String showSearchPage(Model model){
        model.addAttribute("title","Search");
        return "search";
    }
}
