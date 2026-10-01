package org.example.parcialdbp20262.CampusEvent.domain;

import org.example.parcialdbp20262.CampusEvent.infrastructure.CampusEventRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.example.parcialdbp20262.User.infrastructure.UserRepository;

@Service
public class EventService {
    private final CampusEventRepository campusEventRepository;

    public EventService(CampusEventRepository campusEventRepository) {
        this.campusEventRepository = campusEventRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return campusEventRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("No account found for email: " + username));
    }
}