package com.example.BookStore.Jwt;


import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "mysecretkeymysecretkeymysecretkey12345";

    private Key getKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }
    public String  generateToken(String name ,String role){
        return Jwts.builder()
                .setSubject(name)
                .claim("role",role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +1000*60*60))
                .signWith(getKey())
                .compact();
    }
    public String extractUsername(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }



}
