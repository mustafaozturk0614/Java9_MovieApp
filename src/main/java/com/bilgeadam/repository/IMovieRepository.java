package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Genre;
import com.bilgeadam.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findAllByRatingGreaterThan(double rate);

    List<Movie> findAllByPremiredBefore(LocalDate date);

    List<Movie> findAllByPremiredBetween(LocalDate start,LocalDate end);

    List<Movie> findAllByIdIn(List<Long> movies);

    @Query("select m.rating ,count(m.rating) from Movie as m group by m.rating")
    List<Object []> searchByRating();
    @Query("select m.rating ,count(m.rating) from Movie as m group by m.rating")
    List<Tuple> searchByRating2();
    @Query("select m.rating ,count(m.rating) from Movie as m group by m.rating having m.rating=?1")
    Object [] searchByRating(double rate);

    List<Movie> findAllByRatingIn(List<Double> ratings);
}
