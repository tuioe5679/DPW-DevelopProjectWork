package com.tuioe.Develop.Project.Work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String loginCallBack(){
        return "redirect:http://localhost:3000";
    }
}