package org.example.parcialdbp20262.TicketType.infrastructure;

import org.example.parcialdbp20262.TicketType.domain.TicketType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.example.parcialdbp20262.User.domain.User;

import java.util.Optional;

public interface TicketTypeRepository extends JpaRepository<TicketType, Long> {
    Optional<User> findByEventId(Long eventId);
}