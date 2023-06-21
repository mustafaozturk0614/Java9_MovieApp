package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre,Long> {


}
