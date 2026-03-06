package com.example.BookStore.Jwt;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.BookStore.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component
public class JwtFiltter extends OncePerRequestFilter {

    private final JwtUtil jwtutil; //
    private final CustomUserDetailsService customUserDetailsService;
    public JwtFiltter(JwtUtil jwtutil, CustomUserDetailsService customUserDetailsService) {
        this.jwtutil = jwtutil;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        //UsernamePasswordAuthenticationToken authToken = null;
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            String token = authHeader.substring(7);
            String name = jwtutil.extractUsername(token);

            UserDetails userDetails =
                    customUserDetailsService.loadUserByUsername(name);

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                            userDetails,
                            null,
                            userDetails.getAuthorities()
                    );

            SecurityContextHolder.getContext().setAuthentication(authToken);
        }
        filterChain.doFilter(request, response);
    }
}
