package com.shubham.UserAuthenticationService.services;

import com.shubham.UserAuthenticationService.exceptions.UserAlreadyExistsException;
import com.shubham.UserAuthenticationService.models.User;
import com.shubham.UserAuthenticationService.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements IAuthService{

    private final UserRepo userRepo;
    UserRepo userRepository;

    @Autowired
    public AuthService(UserRepo userRepository, UserRepo userRepo) {
        this.userRepository = userRepository;
        this.userRepo = userRepo;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    public User logout(String email) {
        return null;
    }

    @Override
    public User SignUp(String email, String password) throws UserAlreadyExistsException {

        List<User> users = userRepository.findByEmail(email);
        if(!users.isEmpty()) {
            throw new UserAlreadyExistsException("User already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user = userRepository.save(user);

        return user;
    }



}
