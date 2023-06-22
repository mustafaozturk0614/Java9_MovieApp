package com.bilgeadam.controller;

import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

}
