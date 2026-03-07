package com.example.BookStore.service;


import com.example.BookStore.entity.User;
import com.example.BookStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo; // here we create

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(User user){
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);
        return userRepo.save(user);
    }
    public User register(User user){
        user.setRole("USER");
        return userRepo.save(user);
    }




}
