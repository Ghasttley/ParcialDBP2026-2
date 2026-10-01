package org.example.parcialdbp20262.Auth.domain;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.parcialdbp20262.User.domain.User;
import org.example.parcialdbp20262.User.infrastructure.UserRepository;
import org.example.parcialdbp20262.Auth.components.JwtService;
import org.example.parcialdbp20262.Auth.dto.SignUpRequest;
import org.example.parcialdbp20262.Auth.dto.TokenResponse;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponse signUp(SignUpRequest request) {
        User user = userRepository.save(
                new User(
                        request.getEmail(),
                        passwordEncoder.encode(request.getPassword()),
                        request.getFirstName(),
                        request.getLastName(),
                        request.getRole()
                )
        );
        var token = jwtService.generateToken(user);
        return new TokenResponse(token);
    }

    public TokenResponse signIn(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        var user = userRepository.findByEmail(username).orElseThrow();
        var token = jwtService.generateToken(user);
        return new TokenResponse(token);
    }
}