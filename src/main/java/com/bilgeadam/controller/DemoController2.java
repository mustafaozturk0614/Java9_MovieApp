package com.bilgeadam.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo2")
public class DemoController2 {

    @GetMapping("/getname")
    public String getName(){
        return "Merve";
    }
}
