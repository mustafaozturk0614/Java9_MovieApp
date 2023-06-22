package com.bilgeadam.controller;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/save")
     public ResponseEntity<?> createUser(String name, String surname, String email, String password, String phone){
            User user= User.builder().name(name).surName(surname).email(email).phone(phone).password(password).build();
           try {
               userService.save(user);
           }catch (Exception e){
            return     ResponseEntity.badRequest().body(user);
           }
            return  ResponseEntity.ok(user);
     }



     @GetMapping("/register")
    public  ResponseEntity<User> register(RegisterRequestDto dto){
        return  ResponseEntity.ok(userService.register(dto));
    }

    // login metodu yazalım
    // (dışarıdan bir dto alacak daha sonra o dto ile databasede kullanıcı arayacağız
    // eğer kullancı bulunmussa  kullancııyı geri donelim
    //bulunamamıssa hata fırlatalım
    // )

    @GetMapping("/login")
    public ResponseEntity<?> login(LoginRequestDto dto){
        LoginResponseDto user=null;
        try {
           user =userService.login(dto);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Hata olustu:"+e.getMessage());
        }
        return  ResponseEntity.ok(user);
    }

}
