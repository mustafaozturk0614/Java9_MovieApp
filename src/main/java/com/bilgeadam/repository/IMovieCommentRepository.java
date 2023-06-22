package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovieCommentRepository extends JpaRepository<MovieComment,Long> {


}
