package br.com.MeuCasamento.dtos.request.spouse;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginSpouseDTO {
    @Email
    private String email;

    @NotBlank
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
