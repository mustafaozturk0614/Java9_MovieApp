package com.bilgeadam.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequestDto {
    @NotBlank(message = "isim kısmı bos bırakılamaz")
    private String name;
    private String surName;
    @Email(message = "hatalı bir email girişi yaptınız lutfen bilgileri gozden geçiriniz")
    private String email;
    private String phone;
    @NotBlank
    @Size(min = 4, max=32 ,message = "Sifre uzunlugu en az 4 en fazla 32 karakter olamalıdır.")
    private String password;
}
