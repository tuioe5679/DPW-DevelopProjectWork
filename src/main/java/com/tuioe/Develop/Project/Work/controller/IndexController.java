package com.tuioe.Develop.Project.Work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class IndexController {

    @GetMapping("/")
    public String loginCallBack(){
        return "redirect:http://localhost:3000";
    }

    @GetMapping("/username")
    public String currentUserName(Principal principal) {
        return principal.getName();
    }
}
