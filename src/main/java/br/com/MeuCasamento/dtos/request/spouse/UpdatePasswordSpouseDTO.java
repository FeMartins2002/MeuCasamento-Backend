package br.com.MeuCasamento.dtos.request.spouse;

import jakarta.validation.constraints.NotBlank;

public class UpdatePasswordSpouseDTO {
    @NotBlank
    private String currentPassword;

    @NotBlank
    private String newPassword;

    @NotBlank
    private String confirmPassword;

    public String getCurrentPassword() {
        return currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
