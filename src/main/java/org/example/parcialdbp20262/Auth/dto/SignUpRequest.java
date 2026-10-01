package org.example.parcialdbp20262.Auth.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.parcialdbp20262.User.domain.Role;

@Getter
@Setter
public class SignUpRequest {
    private String email, password, firstName, lastName;
    private Role role;
}