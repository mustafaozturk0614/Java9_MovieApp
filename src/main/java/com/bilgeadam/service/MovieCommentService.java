package com.bilgeadam.service;

import com.bilgeadam.repository.IMovieCommentRepository;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.entity.MovieComment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements IServiceCrud<MovieComment> {
   private final IMovieCommentRepository movieCommentRepository;


   @Override
   public MovieComment save(MovieComment movieComment) {
      return null;
   }

   @Override
   public Iterable<MovieComment> saveAll(Iterable<MovieComment> t) {
      return null;
   }

   @Override
   public MovieComment update(MovieComment movieComment) {
      return null;
   }

   @Override
   public void delete(MovieComment movieComment) {

   }

   @Override
   public void deleteById(Long id) {

   }

   @Override
   public List<MovieComment> findAll() {
      return null;
   }

   @Override
   public Optional<MovieComment> findById(long id) {
      return Optional.empty();
   }
}
