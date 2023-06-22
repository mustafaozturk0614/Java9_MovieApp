package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findOptionalByEmailAndPassword(String email,String password);


}
