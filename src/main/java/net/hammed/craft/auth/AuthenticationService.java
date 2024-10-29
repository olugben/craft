package net.hammed.craft.auth;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.hammed.craft.config.JwtService;

import net.hammed.craft.user.User;
import net.hammed.craft.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@RequiredArgsConstructor
public class AuthenticationService {
private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

private final UserRepository repository;
private final PasswordEncoder  passwordEncoder;
private final JwtService jwtService;
private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {

    var user =User.builder()
                            .firstname(request.getFirstname())
                            .lastname(request.getLastname())
                            .email(request.getEmail())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .role(request.getRole())
                            .build();
        repository.save(user);
        var jwtToken =jwtService.generateToken(user);
       
          return AuthenticationResponse.builder().token(jwtToken).build();                  

    }

    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (AuthenticationException e) {
            logger.error("Authentication failed for user: {}", request.getEmail(), e);
            throw e;

        }
       var user= repository.findByEmail(request.getEmail()).orElseThrow();
       var jwtToken =jwtService.generateToken(user);
       
       return AuthenticationResponse.builder().token(jwtToken).build();   
    }

}
