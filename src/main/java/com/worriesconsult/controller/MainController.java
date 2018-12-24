package com.worriesconsult.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController extends BaseApiController{

    @GetMapping("/explain/{page}")
    public String explainpage(@PathVariable String page) {
        return "/explain/" + page;
    }
    @GetMapping("/home/{page}")
    public String homepage(@PathVariable String page){
        return "/home/" + page;
    }
}
