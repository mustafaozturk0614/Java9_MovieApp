package com.bilgeadam.controller;

import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/findbyuserfavgenres")
    public ResponseEntity<Set<Movie>> findByUserFavGenres(Long userId){
            return  ResponseEntity.ok(movieService.findByUserFavGenres(userId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Movie>> findAll()
    {

    return ResponseEntity.ok(movieService.findAll());
    }

}
