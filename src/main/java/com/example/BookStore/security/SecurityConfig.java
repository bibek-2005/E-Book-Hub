package com.example.BookStore.security;
import com.example.BookStore.Jwt.JwtFiltter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
    @Autowired
    private JwtFiltter jwtFiltter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/","/cart").permitAll()
                        .requestMatchers("/admin/").hasRole("ADMIN")
                        .requestMatchers("/books/","/admin/**").hasAnyRole("USER","Admin")
                        // allow register
                        .anyRequest().authenticated() // everything else requires auth
                ).addFilterBefore(jwtFiltter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
        }
        @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
        }
//        @Bean
//        public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//        }
        
}




