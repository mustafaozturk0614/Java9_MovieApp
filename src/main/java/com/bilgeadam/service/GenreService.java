package com.bilgeadam.service;

import com.bilgeadam.repository.IGenreRepository;
import com.bilgeadam.repository.entity.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenreService implements  IServiceCrud<Genre> {
   private final IGenreRepository genreRepository;


   public String deneme(){
      return  "deneme";
   }

   @Override
   public Genre save(Genre genre) {
      return null;
   }

   @Override
   public Iterable<Genre> saveAll(Iterable<Genre> t) {
      return null;
   }

   @Override
   public Genre update(Genre genre) {
      return null;
   }

   @Override
   public void delete(Genre genre) {

   }

   @Override
   public void deleteById(Long id) {

   }

   @Override
   public List<Genre> findAll() {
      return null;
   }

   @Override
   public Optional<Genre> findById(long id) {
      return Optional.empty();
   }
}
