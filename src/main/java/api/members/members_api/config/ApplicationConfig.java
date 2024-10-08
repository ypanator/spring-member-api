package api.members.members_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import api.members.members_api.exception.UserNotFoundException;
import api.members.members_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Configuration @RequiredArgsConstructor
public class ApplicationConfig {
    
    private final UserRepository userRepository;

    @Bean
    UserDetailsService userDetailsService() {
        return username -> {
            return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("No Member with this username"));
        };
    }
}
