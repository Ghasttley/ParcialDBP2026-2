package org.example.parcialdbp20262.EventRegistration.application;

import org.example.parcialdbp20262.User.infrastructure.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-event-registrations")
public class EventRegistrationController {

    private final UserRepository userRepository;

    public EventRegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}