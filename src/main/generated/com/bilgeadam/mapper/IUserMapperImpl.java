package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.dto.response.LoginResponseDto;
import com.bilgeadam.repository.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-10T15:08:51+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public User toUser(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.surName( dto.getSurName() );
        user.email( dto.getEmail() );
        user.phone( dto.getPhone() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public LoginResponseDto toLoginResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        LoginResponseDto.LoginResponseDtoBuilder loginResponseDto = LoginResponseDto.builder();

        loginResponseDto.id( user.getId() );
        loginResponseDto.name( user.getName() );
        loginResponseDto.surName( user.getSurName() );
        loginResponseDto.email( user.getEmail() );
        loginResponseDto.phone( user.getPhone() );
        List<Long> list = user.getFavMovies();
        if ( list != null ) {
            loginResponseDto.favMovies( new ArrayList<Long>( list ) );
        }
        List<Long> list1 = user.getFavGenres();
        if ( list1 != null ) {
            loginResponseDto.favGenres( new ArrayList<Long>( list1 ) );
        }
        loginResponseDto.userType( user.getUserType() );
        List<Long> list2 = user.getComments();
        if ( list2 != null ) {
            loginResponseDto.comments( new ArrayList<Long>( list2 ) );
        }

        return loginResponseDto.build();
    }

    @Override
    public List<LoginResponseDto> toLoginResponseDtos(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<LoginResponseDto> list = new ArrayList<LoginResponseDto>( userList.size() );
        for ( User user : userList ) {
            list.add( toLoginResponseDto( user ) );
        }

        return list;
    }
}
