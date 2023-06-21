package com.bilgeadam.controller;

import com.bilgeadam.service.GenreService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

        @GetMapping("/deneme")
        public String deneme(){
            return genreService.deneme();
        }

}
