package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Genre;
import com.bilgeadam.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {


}
