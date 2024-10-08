package api.members.members_api.service;

import org.springframework.stereotype.Service;

import api.members.members_api.auth.AuthRequest;
import api.members.members_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String register(AuthRequest authRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    public String authenticate(AuthRequest authRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }
    
}
