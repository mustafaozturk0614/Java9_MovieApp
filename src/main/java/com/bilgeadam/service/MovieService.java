package com.bilgeadam.service;

import com.bilgeadam.repository.IGenreRepository;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements IServiceCrud<Movie>{
   private final IMovieRepository movieRepository;


   @Override
   public Movie save(Movie movie) {
      return null;
   }

   @Override
   public Iterable<Movie> saveAll(Iterable<Movie> t) {
      return null;
   }

   @Override
   public Movie update(Movie movie) {
      return null;
   }

   @Override
   public void delete(Movie movie) {

   }

   @Override
   public void deleteById(Long id) {

   }

   @Override
   public List<Movie> findAll() {
      return null;
   }

   @Override
   public Optional<Movie> findById(long id) {
      return Optional.empty();
   }
}
