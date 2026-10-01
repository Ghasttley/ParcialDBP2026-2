package org.example.parcialdbp20262.TicketType.application;

import org.example.parcialdbp20262.User.domain.User;
import org.example.parcialdbp20262.User.dto.UserInfoDto;
import org.example.parcialdbp20262.User.infrastructure.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketTypeController {

    private final UserRepository userRepository;

    public TicketTypeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/private")
    public ResponseEntity<UserInfoDto> getPrivateInfo() {
        User user = currentUser();
        return ResponseEntity.ok(new UserInfoDto(user.getUsername(), user.getRole().name()));
    }

    @GetMapping("/admin")
    public ResponseEntity<UserInfoDto> getAdminInfo() {
        User user = currentUser();
        return ResponseEntity.ok(new UserInfoDto(user.getUsername(), user.getRole().name()));
    }

    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UserInfoDto> getById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new UserInfoDto(user.getUsername(), user.getRole().name()));
    }

    private User currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) auth.getPrincipal();
        return (User) principal;
    }
}