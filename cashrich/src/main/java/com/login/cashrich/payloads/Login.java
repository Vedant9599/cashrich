package com.login.cashrich.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Login {

    private String email;
    private String password;
}
