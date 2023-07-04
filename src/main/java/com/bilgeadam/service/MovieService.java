package com.bilgeadam.service;

import com.bilgeadam.repository.IGenreRepository;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService implements IServiceCrud<Movie>{
   private final IMovieRepository movieRepository;
   private  final UserService userService;

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
      return movieRepository.findAll();
   }

   @Override
   public Optional<Movie> findById(long id) {
      return Optional.empty();
   }

   public Set<Movie> findByUserFavGenres(Long userId) {
   Optional<User> user=userService.findById(userId);

         if (user.isPresent()){
            List<Long> favGenres = user.get().getFavGenres();
            List<Movie> allMovies = findAll();
            Set<Movie> istenen = new HashSet<>();
            for (Movie x : allMovies) {
               for (Long y : x.getGenres()) {
                  if (favGenres.contains(y))
                     istenen.add(x);
                  break;
               }
            }
            return istenen;
        /*    return   findAll().stream()
                    .filter(x->x.getGenres().stream().anyMatch(user.get().getFavGenres()::contains))
                    .collect(Collectors.toSet());*/
         }
         return  new HashSet<>();
   }
}
