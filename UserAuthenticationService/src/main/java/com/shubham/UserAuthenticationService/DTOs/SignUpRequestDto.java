package com.shubham.UserAuthenticationService.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {

    private String email;
    private String password;
}
