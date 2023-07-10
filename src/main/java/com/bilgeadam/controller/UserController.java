package com.bilgeadam.controller;

import com.bilgeadam.dto.request.LoginRequestDto;
import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.excepiton.MovieAppException;
import com.bilgeadam.repository.entity.User;
import com.bilgeadam.service.MovieService;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    @PostMapping("/register")
    public  ResponseEntity<User> register2(@Valid @RequestBody  RegisterRequestDto dto){
        return  ResponseEntity.ok(userService.register(dto));
    }
    // login metodu yazalım
    // (dışarıdan bir dto alacak daha sonra o dto ile databasede kullanıcı arayacağız
    // eğer kullancı bulunmussa  kullancııyı geri donelim
    //bulunamamıssa hata fırlatalım
    // )

    @GetMapping("/login")
    public ResponseEntity<LoginResponseDto> login(LoginRequestDto dto)  {
        LoginResponseDto user=null;

           user =userService.login(dto);

        return  ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login2(@RequestBody LoginRequestDto dto){
        LoginResponseDto user=null;
        try {
            user =userService.login(dto);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Hata olustu:"+e.getMessage());
        }
        return  ResponseEntity.ok(user);
    }

    @GetMapping("/containsname")
    public  ResponseEntity <?> findAllByNameContainingIgnoreCase(String value){
            try {
                return ResponseEntity.ok(userService.findAllByNameContainingIgnoreCase(value));
            }catch (Exception e){
                return  ResponseEntity.badRequest().body("Hata olustu:"+e.getMessage());
            }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<User>> findAll(){
        return  ResponseEntity.ok(userService.findAll());
    }
     @GetMapping("/orderbyname")
    public ResponseEntity <List<User>> findAllByOrderByName(){
        return ResponseEntity.ok( userService.findAllByOrderByName());
    }
    @GetMapping("/containsemail")
    public ResponseEntity <List<User>> findAllByEmailContainingIgnoreCase(String value){
        return ResponseEntity.ok( userService.findAllByEmailContainingIgnoreCase(value));
    }
    @GetMapping("/endwithemail")
    public ResponseEntity <List<User>> findAllByEmailEndingWith(String value){
        return ResponseEntity.ok( userService.findAllByEmailEndingWith(value));
    }

    @GetMapping("/passwordcontrol")
    public ResponseEntity <List<User>> passwordLongerThan(int value){
        return ResponseEntity.ok( userService.passwordLongerThan(value));
    }
    @GetMapping("/passwordcontrol2")
    public ResponseEntity <List<User>> passwordLongerThan2(int value){
        return ResponseEntity.ok( userService.passwordLongerThan2(value));
    }
    @GetMapping("/passwordcontrol3")
    public ResponseEntity <List<User>> passwordLongerThan3(int value){
        return ResponseEntity.ok( userService.passwordLongerThan3(value));
    }
}
