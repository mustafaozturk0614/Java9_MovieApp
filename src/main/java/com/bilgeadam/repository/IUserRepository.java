package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    Optional<User> findOptionalByEmailAndPassword(String email,String password);
    List<User> findAllByNameContainingIgnoreCase(String value);
    List<User> findAllByOrderByName();
    List<User> findAllByEmailContainingIgnoreCase(String value);
    List<User> findAllByEmailEndingWith(String value);
    List<User> findAllByEmailStartingWith(String value);

    @Query("select u from User  as u where length(u.password)>?1")
    List<User> passwordLongerThan(int value);

    @Query(value = "select * from tbl_user  where length(password)>?1",nativeQuery = true)
    List<User> passwordLongerThan2( int value);

    @Query(value = "select u from User  as u where length(u.password)>:x")
    List<User> passwordLongerThan3( @Param("x") int value);

}
