package org.example.parcialdbp20262.CampusEvent.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.parcialdbp20262.TicketType.domain.Status;
import org.example.parcialdbp20262.User.domain.Role;
import org.example.parcialdbp20262.User.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class CampusEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long organizerId;
    private String title, description, location;
    // description: max 500 chars
    private Date eventDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Category category;

    public CampusEvent(Long organizerId, String title, String description, Category category,
                       Date eventDate, String location, Status status) {
        this.organizerId = organizerId;
        this.title = title;
        this.description = description;
        this.category = category;
        this.eventDate = eventDate;
        this.location = location;
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(status.name()));
    }

}