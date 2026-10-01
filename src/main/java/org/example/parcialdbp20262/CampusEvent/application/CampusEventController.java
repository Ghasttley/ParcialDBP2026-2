package org.example.parcialdbp20262.CampusEvent.application;

import org.example.parcialdbp20262.CampusEvent.domain.CampusEvent;
import org.example.parcialdbp20262.CampusEvent.dto.EventInfoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.parcialdbp20262.User.domain.User;
import org.example.parcialdbp20262.CampusEvent.infrastructure.CampusEventRepository;

@RestController
@RequestMapping("/events")
public class CampusEventController {

    private final CampusEventRepository campusEventRepository;

    public CampusEventController(CampusEventRepository campusEventRepository) {
        this.campusEventRepository = campusEventRepository;
    }

    @GetMapping("/private")
    public ResponseEntity<EventInfoDto> getPrivateInfo() {
        User user = currentUser();
        return ResponseEntity.ok(new EventInfoDto(user.getUsername(), user.getRole().name()));
    }

    @GetMapping("/admin")
    public ResponseEntity<EventInfoDto> getAdminInfo() {
        User user = currentUser();
        return ResponseEntity.ok(new EventInfoDto(user.getUsername(), user.getRole().name()));
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<EventInfoDto> getById(@PathVariable Long id) {
        User user = campusEventRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new EventInfoDto(user.getUsername(), user.getRole().name()));
    }

    private User currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return (User) principal;
    }
}