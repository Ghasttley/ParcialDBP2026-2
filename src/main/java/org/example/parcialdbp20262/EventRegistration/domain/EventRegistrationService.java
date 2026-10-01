package org.example.parcialdbp20262.EventRegistration.domain;

import org.example.parcialdbp20262.EventRegistration.infrastructure.EventRegistrationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EventRegistrationService {
    private final EventRegistrationRepository eventRegistrationRepository;

    public EventRegistrationService(EventRegistrationRepository eventRegistrationRepository) {
        this.eventRegistrationRepository = eventRegistrationRepository;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return eventRegistrationRepository.EventId(eventId)
                .orElseThrow(() -> new RepetitionFoundException("Event: " + eventId + "already created."));
    }
}