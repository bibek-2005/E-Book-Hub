package com.example.BookStore.controller;

import com.example.BookStore.DTO.LoginRequest;
import com.example.BookStore.Jwt.JwtUtil;
import com.example.BookStore.entity.User;
import com.example.BookStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;

//    public AuthController(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
    private final JwtUtil jwtUtil;

    public AuthController( JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    private User register(@RequestBody User user){
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    private String login(@RequestBody LoginRequest login,String role){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getName(),
                        login.getPassword())
            );

        return jwtUtil.generateToken(login.getName(),role);
    }



}
