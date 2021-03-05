package com.howei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/wa/index")
    public String waIndex(){
        return "wa/waIndex";
    }
}
