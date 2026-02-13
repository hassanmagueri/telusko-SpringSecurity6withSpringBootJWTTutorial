package com.chom.teluskospringsecurity6withspringbootjwttutorial.Services;

import com.chom.teluskospringsecurity6withspringbootjwttutorial.Models.User;
import com.chom.teluskospringsecurity6withspringbootjwttutorial.Repositories.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRep repo;
    PasswordEncoder encoder;

    @Autowired
    public UserService(UserRep userRepo, PasswordEncoder encoder){
        this.encoder = encoder;
        this.repo = userRepo;
    }

    public User save(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }


}
