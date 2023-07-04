package com.bilgeadam.service;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.mapper.IUserMapper;
import com.bilgeadam.repository.IMovieRepository;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
      return userRepository.findAll();
   }

   @Override
   public Optional<User> findById(long id) {
      Optional<User> user=userRepository.findById(id);
      if (user.isEmpty()){
         System.out.println("Boyle bir kullanıcı bulunamadı");

      }
      return  user;
   }

   public User register(RegisterRequestDto dto) {
      // mappersız yontem
 /*     User user= User.builder().name(dto.getName())
              .surName(dto.getSurName())
              .email(dto.getEmail())
              .password(dto.getPassword())
              .phone(dto.getPhone())
              .build();*/
      // mapperli yontem
      User user= IUserMapper.INSTANCE.toUser(dto);
      return  userRepository.save(user);

   }

   public LoginResponseDto login(LoginRequestDto dto) {
     Optional<User> user =userRepository.findOptionalByEmailAndPassword(dto.getEmail(), dto.getPassword());
     if (user.isEmpty()){
        throw new  RuntimeException("Kullancı adı veya şifre hatalı");
     }
  /*    return  LoginResponseDto.builder().name(user.get().getName())
              .surName(user.get().getSurName())
              .phone(user.get().getPhone())
              .email(user.get().getEmail())
              .favMovies(user.get().getFavMovies())
              .favGenres(user.get().getFavGenres())
              .comments(user.get().getComments())
              .id(user.get().getId())
              .userType(user.get().getUserType())
              .build();*/

      return IUserMapper.INSTANCE.toLoginResponseDto(user.get());
   }

   public  List<LoginResponseDto> findAllByNameContainingIgnoreCase(String value){
       List<User> list= userRepository.findAllByNameContainingIgnoreCase(value);
         if (list.isEmpty()){
            throw new RuntimeException("Aranan kriterde herhangi bri kullanıcı bulunamadı");
         }

       //  return  list.stream().map(x-> IUserMapper.INSTANCE.toLoginResponseDto(x)).collect(Collectors.toList());

         return  IUserMapper.INSTANCE.toLoginResponseDtos(list);
   }

  public List<User> findAllByOrderByName(){
      return userRepository.findAllByOrderByName();
   }
   public  List<User> findAllByEmailContainingIgnoreCase(String value){
      return userRepository.findAllByEmailContainingIgnoreCase(value);
   }
   public  List<User> findAllByEmailEndingWith(String value){
      return  userRepository.findAllByEmailEndingWith(value);
   }

   public  List<User> passwordLongerThan(int value){
      return userRepository.passwordLongerThan(value);
   }
   public  List<User> passwordLongerThan2(int value){
      return userRepository.passwordLongerThan2(value);
   }
   public List<User> passwordLongerThan3(int value){
      return userRepository.passwordLongerThan3(value);
   }
}
