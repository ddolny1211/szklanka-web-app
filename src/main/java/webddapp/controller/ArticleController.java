package webddapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import webddapp.model.Article;
import webddapp.service.ArticleService;

import javax.validation.Valid;

@Controller
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @GetMapping("/add")
    public String forum(Model model, Authentication authentication){
        model.addAttribute("article", new Article());
        model.addAttribute("currentUser", authentication.getName());
        return "addArticle";
    }


    @PostMapping("/save")
    public String saveTime(@ModelAttribute @Valid Article article,
                           BindingResult result){
        if(result.hasErrors()){
            return "addArticle";
        }else{
            articleService.saveArticle(article);
            return "redirect:/forum";
        }

    }

    @GetMapping("/forum")
    public String showAll(Model model){
        model.addAttribute("allArticles",  articleService.getNewestPostes());
        return "forum";
    }
}
