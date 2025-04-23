package com.shubham.UserAuthenticationService.repository;

import com.shubham.UserAuthenticationService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);


}
