package org.example.parcialdbp20262.Auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {
    private String email, password;
}