package org.example.parcialdbp20262.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {
    private String email, password;
}