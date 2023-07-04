package com.bilgeadam.controller;

import com.bilgeadam.dto.response.RatingResponseDto;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.MovieComment;
import com.bilgeadam.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
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

        @GetMapping("/searchbyrating")
       public  ResponseEntity<  List<Object []>> searchByRating(){
        return  ResponseEntity.ok( movieService.searchByRating());
       }
    @GetMapping("/searchbyrating3")
    public  ResponseEntity< Object []> searchByRating( double rate){
        return  ResponseEntity.ok( movieService.searchByRating(rate));
    }
    @GetMapping("/searchbyrating2")
    public  ResponseEntity<List<RatingResponseDto>> searchByRating2(){
        return  ResponseEntity.ok( movieService.searchByRating2());
    }

    @GetMapping("/findbyrating")
    public  ResponseEntity <List<Movie>> findAllByRatingIn(){
        return  ResponseEntity.ok(movieService.findAllByRatingIn());
    }
    @GetMapping("/findbyrating2")
    public  ResponseEntity <List<Movie>> findAllByRatingIn(Double [] ratings){
        return  ResponseEntity.ok(movieService.findAllByRatingIn(ratings));
    }

    @PostMapping("/gtrating/{myrate}")
    public ResponseEntity<List<Movie>> findAllByRatingGreaterThan(@PathVariable double myrate){
        //http://localhost:8390/movie/gtrating/8 --> PathVariable
        //http://localhost:8390/movie/gtrating?rate=8
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(myrate));
    }
    @GetMapping("/gtrating")
    public ResponseEntity<List<Movie>> findAllByRatingGreaterThan2(@RequestParam(required = false) Optional<Double> myrate){
        //http://localhost:8390/movie/gtrating/8 --> PathVariable
        //http://localhost:8390/movie/gtrating?rate=8
if (myrate.isEmpty()){
    return  null;
}
        return ResponseEntity.ok(movieService.findAllByRatingGreaterThan(myrate.get()));

    }
    @GetMapping("/beforedate")
    public ResponseEntity<List<Movie>> findAllByPremiredBefore(@RequestParam(defaultValue = "2023-07-07") String date){
      //  http://localhost:8390/movie/beforedate?date=2010-05-05
        return  ResponseEntity.ok(movieService.findAllByPremiredBefore(date));
    }

}
