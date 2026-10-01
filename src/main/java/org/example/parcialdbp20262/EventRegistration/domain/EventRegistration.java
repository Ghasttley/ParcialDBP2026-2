package org.example.parcialdbp20262.EventRegistration.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.parcialdbp20262.User.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EventRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventId;
    private Long ticketTypeId;
    private Long atendeeId;
    private Date registeredAt;

    @Enumerated(EnumType.STRING)
    private Status status;

    public EventRegistration(Long eventId, Long ticketTypeId, Long atendeeId, Date registeredAt, Status status) {
        this.eventId = eventId;
        this.ticketTypeId = ticketTypeId;
        this.atendeeId = atendeeId;
        this.registeredAt = registeredAt;
        this.status = status;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(status.name()));
    }
}