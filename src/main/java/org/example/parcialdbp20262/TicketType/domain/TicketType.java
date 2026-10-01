package org.example.parcialdbp20262.TicketType.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long eventId;

    private String name;
    private Integer capacity, registeredCount;

    @Enumerated(EnumType.STRING)
    private Status status;

    public TicketType(Long eventId, String name, Integer capacity, Integer registeredCount, Status status) {
        this.eventId = eventId;
        this.name = name;
        this.capacity = capacity;
        this.registeredCount = registeredCount;
        this.status = status;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(status.name()));
    }
}