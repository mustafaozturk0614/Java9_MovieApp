package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Genre;
import com.bilgeadam.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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

}
