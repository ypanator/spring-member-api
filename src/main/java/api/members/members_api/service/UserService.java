package api.members.members_api.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import api.members.members_api.auth.JwtUtil;
import api.members.members_api.auth.AuthRequest;
import api.members.members_api.entity.Role;
import api.members.members_api.entity.User;
import api.members.members_api.exception.UserAlreadyRegisteredException;
import api.members.members_api.exception.UserNotFoundException;
import api.members.members_api.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public String register(@Valid AuthRequest authRequest) {
        userRepository.findByUsername(authRequest.getUsername())
            .ifPresent(user -> {throw new UserAlreadyRegisteredException("Member with this username already registered");});

        User user = User.builder()
            .username(authRequest.getUsername())
            .password(passwordEncoder.encode(authRequest.getPassword()))
            .role(Role.ROLE_USER)
        .build();

        userRepository.save(user);

        return JwtUtil.create(user);
    }

    public String authenticate(@Valid AuthRequest authRequest) {
        User user = getUser(authRequest.getUsername());
        
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
            authRequest.getUsername(), authRequest.getPassword())
        );

        return JwtUtil.create(user);
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UserNotFoundException("User with provided username not found"));
    }
    
}
