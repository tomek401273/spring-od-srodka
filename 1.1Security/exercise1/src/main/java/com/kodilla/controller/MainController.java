package com.kodilla.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/m1")
    public String m1(){
        return "m1";
    }

    @GetMapping("/m2")
    public String m2(){
        return "m2";
    }

    @GetMapping("/m3")
    public String m3(){
        return "m3";
    }
}
