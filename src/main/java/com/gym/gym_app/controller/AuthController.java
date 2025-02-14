package com.gym.gym_app.controller;

import com.gym.gym_app.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

@PostMapping("/authenticate")
public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
    System.out.println("Requête reçue pour l'utilisateur : " + authRequest.getUsername()); // 🔥 Debug

    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
    } catch (Exception e) {
        System.out.println("Échec de connexion pour : " + authRequest.getUsername()); // 🔥 Debug
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
    }

    final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
    String token = jwtUtil.generateToken(userDetails.getUsername());

    System.out.println("Token généré : " + token); // 🔥 Debug
    return ResponseEntity.ok(Map.of("token", token , "username", authRequest.getUsername()));
}

}