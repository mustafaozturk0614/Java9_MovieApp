package com.bilgeadam.dto.response;

import com.bilgeadam.repository.entity.enums.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponseDto {
    private Long id;
    private String name;
    private String surName;
    private String email;
    private String phone;
    private List<Long> favMovies;
    private  List<Long> favGenres;
    private EUserType userType;
    private List<Long> comments;
}
