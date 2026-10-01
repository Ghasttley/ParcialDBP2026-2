package org.example.parcialdbp20262.TicketType.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.parcialdbp20262.User.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}