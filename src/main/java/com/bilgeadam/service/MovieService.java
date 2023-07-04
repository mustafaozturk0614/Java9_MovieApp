package com.bilgeadam.service;

import com.bilgeadam.dto.response.RatingResponseDto;
import com.bilgeadam.repository.IGenreRepository;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import javax.persistence.Tuple;
import java.time.LocalDate;
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

   public   List<Object []> searchByRating(){
      return movieRepository.searchByRating();
   }

  public Object [] searchByRating(double rate){
      return movieRepository.searchByRating(rate);
   }

   public   List<RatingResponseDto> searchByRating2(){
   List<RatingResponseDto> list=new ArrayList<>();
   for (Tuple tuple :movieRepository.searchByRating2()){
      list.add(RatingResponseDto.builder().rating( (Double)  tuple.get(0)).count((Long) tuple.get(1)).build());
   }

   return  list;
   }


  public List<Movie> findAllByRatingIn(){
      return movieRepository.findAllByRatingIn(List.of(7.0,8.0,9.0));
   }

   public List<Movie> findAllByRatingIn(Double [] ratings){
      return movieRepository.findAllByRatingIn(Arrays.asList(ratings));
   }

    public List<Movie> findAllByRatingGreaterThan(double rate) {
    return movieRepository.findAllByRatingGreaterThan(rate);
   }

    public List<Movie> findAllByPremiredBefore(String date) {

        return movieRepository.findAllByPremiredBefore(LocalDate.parse(date));
   }
}
