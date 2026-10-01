package org.example.parcialdbp20262.EventRegistration.domain;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.example.parcialdbp20262.User.infrastructure.UserRepository;

@Service
public class EventRegistrationService {
    private final UserRepository userRepository;

    public EventRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No account found for email: " + username));
    }
}