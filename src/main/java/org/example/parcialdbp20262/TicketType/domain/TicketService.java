package org.example.parcialdbp20262.TicketType.domain;

import org.example.parcialdbp20262.TicketType.infrastructure.TicketTypeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.example.parcialdbp20262.User.infrastructure.UserRepository;

@Service
public class TicketService {
    private final TicketTypeRepository ticketTypeRepository;

    public TicketService(TicketTypeRepository ticketTypeRepository) {
        this.ticketTypeRepository = ticketTypeRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ticketTypeRepository.findByEventId(eventId)
                .orElseThrow(() -> new TicketTypeNotFoundException("No ticket type for event: " + eventId));
    }
}