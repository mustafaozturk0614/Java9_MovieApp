package com.bilgeadam.service;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService  implements  IServiceCrud<User>{
   private final IUserRepository userRepository;


   @Override
   public User save(User user) {
      return userRepository.save(user);
   }

   @Override
   public Iterable<User> saveAll(Iterable<User> t) {
      return null;
   }

   @Override
   public User update(User user) {
      return null;
   }

   @Override
   public void delete(User user) {

   }

   @Override
   public void deleteById(Long id) {

   }

   @Override
   public List<User> findAll() {
      return null;
   }

   @Override
   public Optional<User> findById(long id) {
      return Optional.empty();
   }

   public User register(RegisterRequestDto dto) {
      User user= User.builder().name(dto.getName())
              .surName(dto.getSurName())
              .email(dto.getEmail())
              .password(dto.getPassword())
              .phone(dto.getPhone())
              .build();

      return  userRepository.save(user);

   }

   public LoginResponseDto login(LoginRequestDto dto) {
     Optional<User> user =userRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
     if (user.isEmpty()){
        throw new  RuntimeException("Kullancı adı veya şifre hatalı");
     }
      return  LoginResponseDto.builder().name(user.get().getName())
              .surName(user.get().getSurName())
              .phone(user.get().getPhone())
              .email(user.get().getEmail())
              .favMovies(user.get().getFavMovies())
              .favGenres(user.get().getFavGenres())
              .comments(user.get().getComments())
              .id(user.get().getId())
              .userType(user.get().getUserType())
              .build();
   }


}
