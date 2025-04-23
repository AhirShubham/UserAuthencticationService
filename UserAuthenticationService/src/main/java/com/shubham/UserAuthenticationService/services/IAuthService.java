package com.shubham.UserAuthenticationService.services;

import com.shubham.UserAuthenticationService.exceptions.UserAlreadyExistsException;
import com.shubham.UserAuthenticationService.models.User;

public interface IAuthService {

    User login(String email, String password);

    User logout(String email);

    User SignUp(String email,String password) throws UserAlreadyExistsException;

}
