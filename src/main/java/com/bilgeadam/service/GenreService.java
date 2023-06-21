package com.bilgeadam.service;

import com.bilgeadam.repository.IGenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService {
   private final IGenreRepository genreRepository;


   public String deneme(){
      return  "deneme";
   }

}
