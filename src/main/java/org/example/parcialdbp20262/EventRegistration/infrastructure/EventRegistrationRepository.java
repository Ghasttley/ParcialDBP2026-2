package org.example.parcialdbp20262.EventRegistration.infrastructure;

import org.example.parcialdbp20262.EventRegistration.domain.EventRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.parcialdbp20262.User.domain.User;

import java.util.Optional;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Long> {
    Optional<User> findByEmail(String email);
}