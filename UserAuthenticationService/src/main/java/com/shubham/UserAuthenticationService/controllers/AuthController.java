package com.shubham.UserAuthenticationService.controllers;


import com.shubham.UserAuthenticationService.DTOs.LoginRequestDto;
import com.shubham.UserAuthenticationService.DTOs.LogoutRequestDto;
import com.shubham.UserAuthenticationService.DTOs.SignUpRequestDto;
import com.shubham.UserAuthenticationService.DTOs.UserDTO;
import com.shubham.UserAuthenticationService.models.User;
import com.shubham.UserAuthenticationService.repository.UserRepo;
import com.shubham.UserAuthenticationService.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/auth")
public class AuthController {

    private final UserRepo userRepo;
    AuthService authService;

    @Autowired
    public AuthController(AuthService authService, UserRepo userRepo) {
        this.authService = authService;
        this.userRepo = userRepo;
    }


    @PostMapping("/signUp")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpRequestDto requestDto){
        if(requestDto.getEmail() == null || requestDto.getPassword() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            User user = authService.SignUp(requestDto.getEmail(), requestDto.getPassword());
            return new ResponseEntity<>(from(user), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDto requestDto){
        User user = authService.login(requestDto.getEmail(), requestDto.getPassword());
        return new ResponseEntity<>(from(user),HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<UserDTO> logout(@RequestBody LogoutRequestDto requestDto){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private UserDTO from(User user) {

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;

    }


}
