package webddapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/project")
    public String projectDesc(){
        return "projectDesc";
    }

    @GetMapping("/error")
    public String error(){
        return "error";
    }

}
